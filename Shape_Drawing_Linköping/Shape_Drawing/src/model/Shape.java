package model;
import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.JButton;

/**
*
* Course: 725G91 Object oriented programming in Java
* Linköping University
* 
* Class Shape.java
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/03/2017
* @version 1.0
* 

*/


//abstrakt klass för former
public abstract class Shape implements Serializable
{

	//Början av formen, där musen klickar på skärmen.
	private int x, y;
	private Color color;

	//konstruktor 
	public Shape(int x, int y, Color color) 
	{
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	//getters
	public int getX() 
	{
		return x;
	}

	public int getY() 
	{
		return y;
	}

	//ritar ut 
	public void draw(Graphics g)
	{
		g.setColor(color);
	}
}