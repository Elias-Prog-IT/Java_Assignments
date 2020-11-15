package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
*
* Course: 725G91 Object oriented programming in Java
* Linköping University
* 
* Class ColorSelectorButton.java
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/03/2017
* @version 1.0
* 
*/

public class ColorSelectorButton extends JButton
{
	
	//knappens storlek
	private static final int WIDTH = 51;
	
	private boolean current;
	private Color color; 
	
	//konstruktor
	public ColorSelectorButton(Color color) 
	{
		super();
		this.color = color;
		current = false;
		setPreferredSize(new Dimension(WIDTH, WIDTH));
		setBackground(color);
		refresh();
		setFocusable(false);
	}
	
	//getter och setter
	public Color getColor() 
	{
		return color;
	}
	
	public boolean isCurrent()
	{
		return current;
	}
	
	public void setCurrent(boolean current)
	{
		this.current = current;
		refresh();
	}
	
	//uppdaterar bordern
	public void refresh()
	{
		if(current)
		{
			setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		}
		else
		{
			setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		}
	}
	
}