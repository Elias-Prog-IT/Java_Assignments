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
* Class ShipFire.java
* 
* Shipfire ärver från fire 
* här initerar vi skjutningen för skeppet. 
* 
*/

public class ShipFire extends Fire
{

	public ShipFire(int x, int y, int width, int height, int speed, Ship owner) 
	{
		super(x, y, width, height, speed, Color.GREEN, owner);
		timer = new Timer(speed, new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ShipFire.this.y -= Constants.fireDx;
			}
		});
	}
}