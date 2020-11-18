package model;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.Timer;

import util.Constants;
/**
*
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/03/2017
* @version 1.0
* Course: 725G91 Object oriented programming in Java
* Linköping University
* 
* Class Game.java
* 
* Game är en abstrakt klass som håller koll på spelets status, spelarens status och fiendens status
* powerups, kollisioner mellan spelaren och fienden, game over, mm.
* Här ritar vi ut spelet. 
* Den håller koll på fiendens slumpade skjutning och håller koll på spelarens förflyttning 
* 
* 
* 
*/

public abstract class Game 
{	
	//timer för alien skott och aliens förflyttning neråt och åt sidan.
	private Timer timerAlienDownward;
	private Timer timerAlienSideways;
	private Timer timerAlienFire;

	//slumpar olika tal
	private Random random = new Random();

	//komponenter för spelet
	protected AlienGrid alienGrid;
	protected Player player;
	protected ArrayList<Fire> fires;

	//indikator som känner av vilken powerup som har deklarerats 
	private boolean shotsGiven = false, lifeGiven = false;

	public Game(int alienDownSpeed, int alienDx, int alientSideSpeed) 
	{
		fires = new ArrayList<>();

		//förflyttar alien neråt med timer.
		timerAlienDownward = new Timer(alienDownSpeed, new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				alienGrid.moveDown(alienDx, 400);
			}
		});

		//förflyttning av alien sidleds 
		timerAlienSideways = new Timer(alientSideSpeed, new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				boolean left = random.nextBoolean();
				if(left)
				{
					alienGrid.moveLeft(alienDx, 16);
				}
				else
				{
					alienGrid.moveRight(alienDx, Constants.panelWidth);
				}
			}
		});


		//slumpmässiga skjutningar för alien
		timerAlienFire = new Timer(500, new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				boolean fire = random.nextBoolean();
				if(fire)
				{
					AlienFire alienFire = alienGrid.randomFire(random);
					if(alienFire!=null)
					{
						fires.add(alienFire);
						alienFire.start();
					}
				}
			}
		});
	}

	public abstract Game next();

	public Player getPlayer() 
	{
		return player;
	}


	//ritar ut hela spelet
	public void draw(Graphics g)
	{
		alienGrid.draw(g);
		player.getShip().draw(g);
		for (Fire fire : fires) 
		{
			fire.draw(g);
		}
	}


	//skott från spelaren
	public void playerFire()
	{
		ShipFire shipFire = player.fire();
		if(shipFire!=null)
		{
			fires.add(shipFire);
			shipFire.start();
		}
	}

	//förflyttar player åt vänster
	public void movePlayerLeft()
	{
		player.getShip().moveLeft(10, 0);
	}

	//förflyttar player åt höger
	public void movePlayerRight()
	{
		player.getShip().moveRight(10, Constants.panelWidth);
	}


	//startar processen för alien
	public void start()
	{
		timerAlienDownward.start();
		timerAlienSideways.start();
		for (Fire fire : fires) 
		{
			fire.start();
		}
		timerAlienFire.start();
	}

	//Pausar spelet
	public void pause()
	{
		timerAlienDownward.stop();
		timerAlienSideways.stop();
		for (Fire fire : fires) 
		{
			fire.stop();
		}
		timerAlienFire.stop();
	}


	//kollar kollision mellan alien och skepet
	public void checkCollisions()
	{
		Iterator<Fire> fireIterator = fires.iterator();
		while(fireIterator.hasNext()) 
		{
			Fire fire = fireIterator.next();
			if(fire instanceof AlienFire)//om alien skjuter 
			{ 
				if(player.getShip().isHitting(fire)){ //kollar om skepet blir träffad av skott från alien
					fireIterator.remove(); 
					player.looseLife();
					player.loosePoints(10);
					continue;
				}
			}

			else if(fire instanceof ShipFire)
			{
				//kollar om alien är träffad
				Alien hitAlien = alienGrid.hit((ShipFire)fire);
				if(hitAlien!=null) // om alien är träffad av spelarens skott
				{ 
					player.addPoints(hitAlien.getPoints());
					fireIterator.remove();
					checkPowerUps();
					continue;
				}

			}
		}
	}


	//kollar powerups 
	public void checkPowerUps()
	{
		
		int total = alienGrid.totalAliens();
		int alive = alienGrid.aliveAliens();

		if(alive == 0)
		{ 			//om första nivån på spelet är uppklarat, så ger vi den andra powerup:en som spelaren inte har fått än.
			if(!shotsGiven)
			{
				player.powerUpShots(Constants.extraAmmoPowerUp);
				shotsGiven = true;
			}
			else if(!lifeGiven)
			{
				player.powerUpLife();
				lifeGiven = true;
			}

		}

		//om man har lyckats döda hälften av aliens eller är halvvägs in i spelet. 
		else if(total/2 == alive)
		{
			//slumpade powerups av extra skott eller liv
			boolean giveShots = random.nextBoolean();

			if(giveShots && !shotsGiven)
			{
				player.powerUpShots(Constants.extraAmmoPowerUp);
				shotsGiven = true;
			}

			if(!giveShots && !lifeGiven)
			{
				player.powerUpLife();
				lifeGiven = true;
			}
		}

	}
	//Spelet är över om man har lyckats slutföra alla nivåer i spelet, om spelaren har inga liv kvar, eller om man har tagit slut på alla skott
	public boolean gameOverCheck()
	{
		return(alienGrid.aliveAliens() == 0 || (player.getLives() == 0) || (player.getShots() == 0));
	}

	//kollar om nivån man är på är färdig
	public boolean isComplete()
	{
		return alienGrid.aliveAliens() == 0;
	}

	//uppdaterar spelet
	public void refresh()
	{
		checkCollisions();
	}
}