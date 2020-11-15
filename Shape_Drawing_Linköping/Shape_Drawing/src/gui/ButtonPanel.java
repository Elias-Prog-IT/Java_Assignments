package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Drawing;

/**
*
* Course: 725G91 Object oriented programming in Java
* Linköping University
* 
* Class ButtonPanel.java
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/03/2017
* @version 1.0
* 
*/

//Representerar knapppanel
public class ButtonPanel extends JPanel 
{

	public ButtonPanel(final DrawingPanel drawingPanel) 
	{
		new GridLayout(1, 0);

		//knappen för att reseta 
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				drawingPanel.getDrawing().clear();
				drawingPanel.repaint();
			}
		});
		// knappen för att kunna spara
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser fileChooser = new JFileChooser();
				int choice = fileChooser.showSaveDialog(null);
				if (choice == JFileChooser.APPROVE_OPTION) //om man trycker på ok efter att ha valt filen.
				{
					try {
						// sparar
						ObjectOutputStream oos = new ObjectOutputStream(
								new FileOutputStream(fileChooser.getSelectedFile()));
						oos.writeObject(drawingPanel.getDrawing());
						oos.close();
						JOptionPane.showMessageDialog(null, "Drawing saved!");
					} 
					catch (IOException e1) 
					{
						JOptionPane.showMessageDialog(null, "Drawing cannot be saved!");
					}
				}
			}
		});

		// för att kunna öppna filen
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser fileChooser = new JFileChooser();
				int choice = fileChooser.showOpenDialog(null);
				if (choice == JFileChooser.APPROVE_OPTION) 
				{
					try 
					{
						// öppna
						ObjectInputStream oos = new ObjectInputStream(
								new FileInputStream(fileChooser.getSelectedFile()));
						Drawing drawing = (Drawing) oos.readObject();
						oos.close();
						drawingPanel.setDrawing(drawing);
						drawingPanel.repaint();
						JOptionPane.showMessageDialog(null, "Drawing loaded!");
					} 
					catch (Exception e1) 
					{
						JOptionPane.showMessageDialog(null, "Drawing cannot be loaded!");
					}
				}
			}
		});

		add(btnReset);
		add(btnSave);
		add(btnOpen);
	}
}