package model;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

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
* Class Alien.java
* 
* Här representerar vi fienden "Alien". Klassen ärver från Performer klassen. 
* Ritar ut alien och kontrollerar hur alien skjuter.
* 
*/

public class Alien extends Performer
{

	//poäng för alien
	private int points;
	
	private BufferedImage image;
	
	//skapar alien
	public Alien(int x, int y, int width, int height, int points, BufferedImage image) 
	{
		super(x, y, width, height);
		this.points = points;
		this.image = image;
	}
	
	public int getPoints() 
	{
		return points;
	}
	
	//ritar ut
	@Override
	public void draw(Graphics g)
	{
		g.drawImage(image.getScaledInstance(width, height, BufferedImage.SCALE_FAST), x, y, null);
	}
	
	//alien skott
	public AlienFire fire()
	{
		return new AlienFire(x + (width)/2 - Constants.fireWidth, y + height, Constants.fireWidth, Constants.fireHeight, Constants.fireSpeed, this);
	}
}
