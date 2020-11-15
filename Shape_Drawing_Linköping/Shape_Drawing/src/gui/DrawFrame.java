package gui;
import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
*
* Course: 725G91 Object oriented programming in Java
* Linköping University
* 
* Class DrawFrame.java
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/03/2017
* @version 1.0
* 
*/

//Ritar ramen klassen
public class DrawFrame extends JFrame{

	//Panelen för ramen
	private ColorsSelectorPanel colorsSelectorPanel;
	private ShapesPanel shapesPanel;
	private DrawingPanel drawingPanel;
	private ButtonPanel buttonPanel;
	
	
	public DrawFrame() 
	{
		setTitle("Välkommen till Ritprogrammet!");
		
		//Skapar paneler
		colorsSelectorPanel = new ColorsSelectorPanel();
		shapesPanel = new ShapesPanel();
		drawingPanel = new DrawingPanel(colorsSelectorPanel, shapesPanel);
		buttonPanel = new ButtonPanel(drawingPanel);
		
		
		add(drawingPanel, BorderLayout.CENTER);
		add(colorsSelectorPanel, BorderLayout.WEST);
		add(shapesPanel, BorderLayout.EAST);
		add(buttonPanel, BorderLayout.SOUTH);
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null); 
		setVisible(true);
	}
}