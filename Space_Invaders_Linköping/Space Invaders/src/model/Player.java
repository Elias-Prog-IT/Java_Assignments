package model;

import java.util.Scanner;

import javax.swing.JOptionPane;
/**
*
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/03/2017
* @version 1.0
* Course: 725G91 Object oriented programming in Java
* Linköping University
* 
* Class Player.java
* 
* Player klassen tar emot spelarens namn, håller koll på 
* spelarens liv, poäng och skott.
* 
*/

public class Player 
{

	Scanner in = new Scanner(System.in);
	
	//spelarens variabler 
	private Ship ship;
	private int lives;
	private int score;
	private int shots;
	private String pName = " ";

	public Player(Ship ship, int lives, int shots) 
	{

		pName = JOptionPane.showInputDialog("Please type in your name").toUpperCase();

		this.ship = ship;
		this.lives = lives;
		this.shots = shots;
	}

	public Ship getShip()
	{
		return ship;
	}

	public int getLives()
	{
		return lives;
	}

	public int getScore() 
	{
		return score;
	}

	public int getShots() 
	{
		return shots;
	}


	public void setScore(int score) 
	{
		this.score = score;
	}

	//skott
	public ShipFire fire()
	{
		if(shots == 0)
		{
			return null;
		}
		else
		{
			shots--;
			return ship.fire();
		}
	}

	//förlorar liv
	public void looseLife()
	{
		if(lives > 0)
			lives--;
	}

	//adderar poängen
	public void addPoints(int pts)
	{
		score += pts;
	}

	//subtraherar poängen
	public void loosePoints(int pts)
	{
		score -= pts;
		if(score < 0)
		{
			score = 0;
		}
	}

	//lägger till liv
	public void powerUpLife()
	{
		lives++;
	}

	//lägger till skott
	public void powerUpShots(int additional)
	{
		shots += additional;
	}

	public String getpName() 
	{
		return pName;
	}

	public void setpName(String pName) 
	{
		this.pName = pName;
	}
}