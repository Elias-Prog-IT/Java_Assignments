package model;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;
/**
*
* Course: 725G91 Object oriented programming in Java
* Linköping University
* 
* Class Drawing.java
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/03/2017
* @version 1.0
* 

*/


//Representerar en ritning
public class Drawing implements Serializable
{
	private ArrayList<Shape> shapes;
	
	public Drawing() 
	{
		shapes = new ArrayList<>();
	}
	
	//Lägger till former till ritfunktionen
	public void addShape(Shape shape)
	{
		shapes.add(shape);
	}
	
	public void clear()
	{
		shapes.clear();
	}
	
	//ritar ut formerna
	public void draw(Graphics g)
	{
		for (Shape shape : shapes) 
		{
			shape.draw(g);
		}
	}
}