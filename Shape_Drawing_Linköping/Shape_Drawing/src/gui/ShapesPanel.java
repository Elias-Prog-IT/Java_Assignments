package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Shape;
import model.ShapeType;

/**
*
* Course: 725G91 Object oriented programming in Java
* Linköping University
* 
* Class ShapesPanel.java
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/03/2017
* @version 1.0
* 
*/


//Panelen för att välja former
public class ShapesPanel extends JPanel
{
	private ShapeSelectorButton[] buttons;
	private ShapeSelectorButton current;
	
	public ShapesPanel() 
	{
		//Skapar knapparna för formerna
		buttons = new ShapeSelectorButton[ShapeType.values().length];
		buttons[0] = new ShapeSelectorButton(ShapeType.CIRCLE, "circle.png");
		buttons[1] = new ShapeSelectorButton(ShapeType.SQUARE, "square.png");
		buttons[2] = new ShapeSelectorButton(ShapeType.TRIANGLE, "triangle.png");
		current = buttons[0];
		current.setCurrent(true);
		
		//sub panel för knapparna
		JPanel panel = new JPanel(new GridLayout(0, 1));
		
		for (int i = 0; i < buttons.length; i++) 
		{
			buttons[i].addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					current.setCurrent(false);
					current = (ShapeSelectorButton) e.getSource();
					current.setCurrent(true);
				}
			});
			panel.add(buttons[i]);
		}
		add(panel);
		panel.setBorder(BorderFactory.createTitledBorder("Shapes"));
	}

	public ShapeType getCurrent() 
	{
		return current.getType();
	}
}