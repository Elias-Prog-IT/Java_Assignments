package model;

import java.awt.Graphics;
import java.awt.Rectangle;
/**
*
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/03/2017
* @version 1.0
* Course: 725G91 Object oriented programming in Java
* Linköping University
* 
* Class Performer.java
* 
* Performer är superklass till Alien, Ship, och Fire klasserna.
* Performer är en abstrakt klass. 
* Initierar metoder som överskuggas till underklasserna 
* Performer klassen håller koll om skotten träffar 
* 
*/

public abstract class Performer 
{

	//dimensioner
	protected int x, y, width, height;

	//konstruktor
	public Performer(int x, int y, int width, int height) 
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	
	//Getters
	
	public int getX() 
	{
		return x;
	}

	public int getY() 
	{
		return y;
	}

	public int getWidth() 
	{
		return width;
	}

	public int getHeight() 
	{
		return height;
	}

	public abstract void draw(Graphics g);

	
	//Metoder som gör så att man kan förflytta sig
	public void moveDown(int dx, int bounds)
	{
		y = y + dx;
	}
	
	public void moveLeft(int dx, int bounds)
	{
		x = x - dx;
	}
	
	public void moveRight(int dx, int bounds)
	{
		x = x + dx;
	}
	
	public boolean canMoveLeft(int dx, int bounds)
	{
		return x - dx >= bounds;
	}
	
	public boolean canMoveRight(int dx, int bounds)
	{
		return x + dx <= bounds;
	}
	
	public boolean canMoveDown(int dx, int bounds)
	{
		return y + dx <= bounds;
	}
	
	public boolean isHitting(Fire fire)
	{
		return new Rectangle(x, y, width, height).intersects(new Rectangle(fire.x, fire.y, fire.width, fire.height));
	}
}
