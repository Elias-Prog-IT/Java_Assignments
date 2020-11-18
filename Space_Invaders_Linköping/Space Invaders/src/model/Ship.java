package model;

import java.awt.Color;
import java.awt.Graphics;

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
* Class Ship.java
* 
* Här ritar vi ut skeppet för spelaren.
* skeppets förflyttning och metoden att skjuta
* 
*/

public class Ship extends Performer 
{

	public Ship(int x, int y, int width, int height) 
	{
		super(x, y, width, height);
	}

	//ritar ut skepet
	@Override
	public void draw(Graphics g) 
	{
		g.setColor(Color.RED);
		g.fillRect(x, y , width, height);
		g.setColor(Color.YELLOW);
		g.fillRect(x + (width - width/4)/2, y - height/4, width/4, height/4);
	}

	//skepets skott
	public ShipFire fire()
	{
		return new ShipFire(x + (width - width/4)/2, y - height/4 - Constants.fireHeight, Constants.fireWidth, Constants.fireHeight, Constants.fireSpeed, this);
	}

	@Override
	public void moveLeft(int dx, int bounds) 
	{
		super.moveLeft(dx, bounds);
		if(x < bounds)
			x = bounds;
	}

	@Override
	public void moveRight(int dx, int bounds) 
	{
		super.moveRight(dx, bounds);
		if(x + width > bounds)
			x = bounds - width;
	}
}