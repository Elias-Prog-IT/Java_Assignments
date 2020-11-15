package model;
import java.awt.Color;
import java.awt.Graphics;

/**
*
* Course: 725G91 Object oriented programming in Java
* Linköping University
* 
* Class Triangle.java
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/03/2017
* @version 1.0
* 
*/


//Triangle klassen
public class Triangle extends Shape
{
	
	private static final int SIDE = 50;

	public Triangle(int x, int y, Color color) 
	{
		super(x, y, color);
	}

	@Override
	public void draw(Graphics g) 
	{
		super.draw(g);
		
		//hämtar x och y
		int x1 = getX();
		int y1 = getY();
		
		//hämtar höjden på triangeln
		double height = SIDE * Math.sqrt((3) / 2);
		
		//får mitten av motstående sida till nuvarande punkt.
		double midPointX = x1;
		double midPointY = y1 + height;
		
		//hämtar de andra två punkterna
		int x2 = (int) (midPointX  - SIDE/2);
		int y2 = (int) (midPointY);
		
		int x3 = (int) (midPointX  + SIDE/2);
		int y3 = (int) (midPointY);
		
		//ritar ut polygon med punkter
		g.fillPolygon(new int[] {x1, x2, x3}, new int[] {y1, y2, y3}, 3);
	}
}