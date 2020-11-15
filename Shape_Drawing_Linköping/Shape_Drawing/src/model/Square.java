package model;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;

/**
*
* Course: 725G91 Object oriented programming in Java
* Linköping University
* 
* Class Square.java
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/03/2017
* @version 1.0
* 
*/


//fyrkantens klass
public class Square extends Shape
{
	private static final int SIDE = 50;

	public Square(int x, int y, Color color) 
	{
		super(x, y, color);
	}

	@Override
	public void draw(Graphics g) 
	{
		super.draw(g);
		g.fillRect(getX(), getY(), SIDE, SIDE);
	}
}