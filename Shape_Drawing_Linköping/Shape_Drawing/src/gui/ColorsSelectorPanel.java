package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
*
* Course: 725G91 Object oriented programming in Java
* Linköping University
* 
* Class ColorsSelectorPanel.java
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/03/2017
* @version 1.0
* 
*/

//Panel för färger
public class ColorsSelectorPanel extends JPanel
{
	private static final Color[] COLORS = { Color.BLACK, Color.WHITE, Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN,
			Color.MAGENTA, Color.CYAN };

	//för att behålla nuvarande valda färgen
	private ColorSelectorButton current;
	
	private ColorSelectorButton[] buttons;

	public ColorsSelectorPanel() 
	{
		setLayout(new GridLayout(0, 1));
		buttons = new ColorSelectorButton[COLORS.length];

		for (int i = 0; i < COLORS.length; i++) 
		{
			//skapar knappen
			ColorSelectorButton button = new ColorSelectorButton(COLORS[i]);
			buttons[i] = button;
			add(button);  
			
			button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					current.setCurrent(false);
					current = (ColorSelectorButton) e.getSource();
					current.setCurrent(true);
				}
			});
		}

		//sätter första färgen som nuvarande
		current = buttons[0];
		current.setCurrent(true);

		//sätter gränsen
		setBorder(BorderFactory.createTitledBorder("Colors"));
	}
	
	public Color getCurrent()
	{
		return current.getColor();
	}
}