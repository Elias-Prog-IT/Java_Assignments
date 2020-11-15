package gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.ShapeType;

/**
*
* Course: 725G91 Object oriented programming in Java
* Linköping University
* 
* Class ShapeSelectorButton.java
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/03/2017
* @version 1.0
* 
*/

//Klassen för att välja olika formar
public class ShapeSelectorButton extends JButton{

	//variant av form
	private ShapeType type;
	
	//behåller nuvarande form eller inte
	private boolean current;
	 
	//skappar knappar
	public ShapeSelectorButton(ShapeType type, String fileName) 
	{
		super(new ImageIcon(fileName));
		setContentAreaFilled(false);
		refresh();
		setFocusable(false);
		this.type = type;
	}
	
	//getter och setter
	public ShapeType getType() 
	{
		return type;
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
	
	//Sätter gränsen till border
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