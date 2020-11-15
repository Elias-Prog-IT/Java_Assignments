package model;
import java.awt.Color;
import java.awt.Graphics;
/**
*
* Course: 725G91 Object oriented programming in Java
* Linköping University
* 
* Class Circle.java
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/03/2017
* @version 1.0
* 

*/


//Cirkel klassen
public class Circle extends Shape
{
	
	private static final int DIAMETER = 50;

	public Circle(int x, int y, Color color) 
	{
		super(x, y,color);
	}
	
	public void draw(Graphics g) 
	{
		super.draw(g);
		g.fillOval(getX() - DIAMETER/2, getY() - DIAMETER/2, DIAMETER, DIAMETER);
	}
}