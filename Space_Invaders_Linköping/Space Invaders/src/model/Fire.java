package model;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Timer;
/**
*
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/03/2017
* @version 1.0
* Course: 725G91 Object oriented programming in Java
* Linköping University
* 
* Class Fire.java
* 
* Representerar en abstrakt klass för arv till både alienfire och shipfire
* 
*/

public abstract class Fire extends Performer{

	private int speed;
	private Color color;
	protected Performer owner;
	protected Timer timer;
	
	//skapar skott
	public Fire(int x, int y, int width, int height, int speed, Color color, Performer owner) 
	{
		super(x, y, width, height);
		this.speed = speed;
		this.color = color;
		this.owner = owner;
	}

	public int getSpeed()
	{
		return speed;
	}

	public Color getColor()
	{
		return color;
	}
	
	//ritar ut
	@Override
	public void draw(Graphics g)
	{
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
	
	public void start()
	{
		timer.start();
	}
	
	public void stop()
	{
		timer.stop();
	}
}