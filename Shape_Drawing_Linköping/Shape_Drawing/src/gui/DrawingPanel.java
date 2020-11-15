package gui;

/**
*
* Course: 725G91 Object oriented programming in Java
* Linköping University
* 
* Class DrawingPanel.java
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/03/2017
* @version 1.0
* 
*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Circle;
import model.Drawing;
import model.Shape;
import model.ShapeType;
import model.Square;
import model.Triangle;

//Ritningspanel klassen
public class DrawingPanel extends JPanel
{
	//ritningen för panelen
	private Drawing drawing; 
	private ColorsSelectorPanel colorsSelectorPanel; 
	private ShapesPanel shapesPanel;
	
	//sätter storlek och bakgrund
	public DrawingPanel(ColorsSelectorPanel colorsSelectorPanel, ShapesPanel shapesPanel)
	{
		setPreferredSize(new Dimension(800, 800)); //sätt storlek
		setBackground(Color.WHITE);
		drawing = new Drawing(); //skapa ny ritning
		this.colorsSelectorPanel = colorsSelectorPanel;
		this.shapesPanel = shapesPanel;
		
		addMouseListener(new MouseClickListener());
	}
	
	private class MouseClickListener extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			drawShape(e);
		}
		
		@Override
		public void mousePressed(MouseEvent e) 
		{
			drawShape(e);
		}
	}
	
	//Ritar nuvarande form med den valda färgen, vid musklick.
	public void drawShape(MouseEvent e)
	{
		ShapeType shapeType = shapesPanel.getCurrent();
		Color color = colorsSelectorPanel.getCurrent();
		
		switch (shapeType) 
		{
		case CIRCLE:
			drawing.addShape(new Circle(e.getX(), e.getY(), color));
			break;
	
		case SQUARE:
			drawing.addShape(new Square(e.getX(), e.getY(), color));
			break;
			
		case TRIANGLE:
			drawing.addShape(new Triangle(e.getX(), e.getY(), color));
			break;

		default:
			break;
		}
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawing.draw(g);
	}
	
	public Drawing getDrawing()
	{
		return drawing;
	}
	
	public void setDrawing(Drawing drawing)
	{
		this.drawing = drawing;
	}
}