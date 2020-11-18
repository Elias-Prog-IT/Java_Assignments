package model;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

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
* Class AlienFire.java
* 
* Representerar skottlossning för Alien. 
* Ärver från klassen Fire.
* 
*/

public class AlienFire extends Fire
{
	public AlienFire(int x, int y, int width, int height, int speed, Alien owner) 
	{
		super(x, y, width, height, speed, Color.BLUE, owner);
		timer = new Timer(speed, new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				AlienFire.this.y += Constants.fireDx;
			}
		});
	}
}
