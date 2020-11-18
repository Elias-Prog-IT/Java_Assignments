package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

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
* Class AlienGrid.java
* 
* Representerar Aliens i ett rutnät. Ritar ut rutnätet.
* Styr hur rutnätet av aliens ska röra på sig
* Aliens har möjligheten att skjuta samt kollar om aliens är träffade av spelarens skott.
* Kollar också om det finns aliens kvar i rutnätet. 
* 
*/

public class AlienGrid 
{
	private Alien[][] aliens; // här skapar vi arrayen för alien, rutnätet.

	//konstruktor för att skapa aliens.
	public AlienGrid(int rows, int cols, BufferedImage image, int alienPoints) 
	{
		aliens = new Alien[rows][cols];
		for (int i = 0; i < aliens.length; i++) 
		{
			for (int j = 0; j < aliens[i].length; j++) //här skapar vi distansen mellan alla aliens som finns i rutnätet, på x och y-led
			{
				int y = 64 + i * 32 + i * 8;
				int x = 16 + j * 32 + j * 8;
				Alien alien = new Alien(x, y, Constants.alienWidth, Constants.alienHeight, alienPoints, image);
				aliens[i][j] = alien;
			}
		}
	}

	//ritar ut rutnätet
	public void draw(Graphics g)
	{
		for (int i = 0; i < aliens.length; i++) 
		{
			for (int j = 0; j < aliens[i].length; j++) 
			{
				if(aliens[i][j] != null)
					aliens[i][j].draw(g);
			}
		}
	}


	//förflyttar rutnättet neråt
	public void moveDown(int dx, int bounds)
	{
		//kollar om rutnätet kan fortsätta förflytta sig neråt
		for (int i = 0; i < aliens.length; i++) 
		{
			for (int j = 0; j < aliens[i].length; j++) 
			{
				if(aliens[i][j] != null && !aliens[i][j].canMoveDown(dx, bounds - ((aliens.length - i) * 32 + (aliens.length - i) * 8)))
					return;
			}
		}

		for (int i = 0; i < aliens.length; i++) 
		{
			for (int j = 0; j < aliens[i].length; j++)
			{
				if(aliens[i][j] != null)
					aliens[i][j].moveDown(dx, bounds - ((aliens.length - i) * 32 + (aliens.length - i) * 8) );
			}
		}
	}

	//flyttar åt vänster
	public void moveLeft(int dx, int bounds)
	{
		for (int i = 0; i < aliens.length; i++) 
		{
			for (int j = 0; j < aliens[i].length; j++) 
			{
				if(aliens[i][j] != null && !aliens[i][j].canMoveLeft(dx, bounds + j * 32)){
					return;
				}
			}
		}

		for (int i = 0; i < aliens.length; i++) 
		{
			for (int j = 0; j < aliens[i].length; j++) 
			{
				if(aliens[i][j] != null)
					aliens[i][j].moveLeft(dx, bounds + i * 32 );
			}
		}
	}


	//flyttar åt höger
	public void moveRight(int dx, int bounds)
	{
		for (int i = 0; i < aliens.length; i++) 
		{
			for (int j = 0; j < aliens[i].length; j++) 
			{
				if(aliens[i][j] != null && !aliens[i][j].canMoveRight(dx,bounds -  (aliens.length - j - 1) * 32))
					return;
			}
		}

		for (int i = 0; i < aliens.length; i++) 
		{
			for (int j = 0; j < aliens[i].length; j++)
			{
				if(aliens[i][j] != null)
					aliens[i][j].moveRight(dx,  bounds - ((aliens.length - j) * 32));
			}
		}
	}

	//skapar slumpmässiga skjutningar
	public AlienFire randomFire(Random random)
	{
		int i = random.nextInt(aliens.length);
		int j = random.nextInt(aliens[0].length);
		if (aliens[i][j] != null) 
		{
			return aliens[i][j].fire();
		}
		else 
		{
			return null;
		}
	}

	//kollar om någon alien är träffad av spelarens skott
	public Alien hit(ShipFire shipFire)
	{
		for (int i = 0; i < aliens.length; i++) 
		{
			for (int j = 0; j < aliens[i].length; j++) 
			{
				if(aliens[i][j]!=null && aliens[i][j].isHitting(shipFire)){
					Alien hit = aliens[i][j];
					aliens[i][j] = null;
					return hit;
				}
			}
		}
		return null;
	}

	//räknar antal aliens
	public int totalAliens()
	{
		return aliens[0].length * aliens.length;
	}

	//räknar antal levande aliens
	public int aliveAliens()
	{
		int count = 0;
		for (int i = 0; i < aliens.length; i++) 
		{
			for (int j = 0; j < aliens[i].length; j++) 
			{
				if(aliens[i][j] != null)
					count++;
			}
		}
		return count;
	}
}