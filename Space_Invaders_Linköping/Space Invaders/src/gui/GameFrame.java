package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.Game;
import model.Level1;
//import model.Player;
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
* Class GameFrame.java
* 
* Det här representerar GUI för spelet.
* Den ritar ut spelfönstret, menun, spelarens liv, poäng och skott.
* 
*/

public class GameFrame extends JFrame {

	// Variabler
	private boolean running;
//	private String date = " ";
	
	private Game game;

	// spelpanelen
	private GamePanel gamePanel;
	private StatusPanel statusPanel;

	public GameFrame() {
		super("Space Invaders");

		setupMenubar();

		// Panelen skapas 
		gamePanel = new GamePanel();
		add(gamePanel);

		statusPanel = new StatusPanel();
		add(statusPanel, BorderLayout.NORTH);

		// storleken på fönstret
		pack();
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

		gamePanel.setFocusable(true);
		gamePanel.requestFocus();
	}



	public void setupMenubar() { // menu metoden


		JMenuBar menuBar = new JMenuBar();

		JMenu menuOptions = new JMenu("Options");

		
		JMenuItem Play = new JMenuItem("Play");
		JMenuItem HighScore = new JMenuItem("High Scores");
		JMenuItem Exit = new JMenuItem("Exit");

		menuOptions.add(Play);
		menuOptions.add(HighScore);
		menuOptions.addSeparator();
		menuOptions.add(Exit);

		menuBar.add(menuOptions);

		setJMenuBar(menuBar);

		//Listener till playknappen
		Play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gamePanel.newGame();
			}
		});


		//Listener till highscoreknappen
		HighScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(GameFrame.this, "Highest Score: "+getScore());
			}
		});
				

		
		//Listener till exit knappen
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(game!=null){
					updateScore();
					game.pause();
					gamePanel.timerRefresh.stop();
				}
				System.exit(0);
			}
		});
	}

	private class GamePanel extends JPanel implements KeyListener {

		//uppdaterar spelet
		private Timer timerRefresh;

		public GamePanel() {
			// skapar en timer som uppdaterar varje 50 ms
			timerRefresh = new Timer(50, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//om spelet inte är igång
					if (game == null || !running)
						return;

					//uppdaterar
					game.refresh();
					statusPanel.refreshStats();

					//kollar om spelet är över
					if (game.gameOverCheck()) {
						updateScore();
						running = false;
						game.pause();

						if (game.isComplete()) { //tar sig vidare efter första nivån, om spelaren har lyckats döda alla fiender
							game = game.next();
							if (game != null) {
								running = true;
								timerRefresh.start();
								game.start();

							}
						}

						//Frågar om spelaren vill starta om spelet.
						if (!running) {
							int choice = JOptionPane.showConfirmDialog(GameFrame.this, "Game over. Play again? ");
							if (choice == JOptionPane.YES_OPTION) {
								game = new Level1();
								game.start();
								running = true;
							} else {
								timerRefresh.stop();
							}
						}
					}
					repaint();
				}
			});

			setBackground(Color.BLACK);
			setPreferredSize(new Dimension(Constants.panelWidth, Constants.panelHeight));
			setLayout(null);
			addKeyListener(this);
		}


		//startar ett nytt spel på nivå 1
		public void newGame() {
			game = new Level1();
			repaint();
			startGame();
		}

		// startar spelet
		public void startGame() {
			timerRefresh.start();
			game.start();
			repaint();
			running = true;
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (game != null)
				game.draw(g);

		}

		@Override
		public void keyTyped(KeyEvent e) {

		}


		//Känner om spelaren trycker på en specifik knapp som stämmer överens med det inom metoden
		@Override
		public void keyPressed(KeyEvent e) {
			if (game == null)
				return;

			//mellanslag
			if (running && e.getKeyCode() == KeyEvent.VK_SPACE) {
				game.playerFire();
			}

			//vänstra pilknapp 
			else if (running && e.getKeyCode() == KeyEvent.VK_LEFT) {
				game.movePlayerLeft();
			}

			//högra pilknapp
			else if (running && e.getKeyCode() == KeyEvent.VK_RIGHT) {
				game.movePlayerRight();
			}

			//pause knappen som är 'P'
			else if (e.getKeyCode() == KeyEvent.VK_P) {

				if (running ) 
				{
					game.pause();
					timerRefresh.stop();
					JOptionPane.showMessageDialog(null, "The game has paused! Press 'P' again to resume the game");
					
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "The game has resumed");
					game.start();
					timerRefresh.start();
				}
				running = !running;
			}
			repaint();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}

	//status panelen
	private class StatusPanel extends JPanel {

		//Visar spelarens liv, poäng och antal skott man har
		private JLabel playerLives, playerScore, playerAmmo;

		public StatusPanel() {
			setLayout(new GridLayout(0, 3));

			playerLives = new JLabel("Lives: 0");
			playerScore = new JLabel("Score: 0");
			playerAmmo = new JLabel("Ammo: 0");

			add(playerLives);
			add(playerScore);
			add(playerAmmo);
		}

		public void refreshStats() 
		{
			if (game == null) 
			{
				playerLives.setText("Lives: 0");
				playerScore.setText("Score: 0");
				playerAmmo.setText("Shots: 0");
			} 
			else 
			{
				playerLives.setText("Lives: " + game.getPlayer().getLives());
				playerScore.setText("Score: " + game.getPlayer().getScore());
				playerAmmo.setText("Shots: " + game.getPlayer().getShots());
			}
		}
	}

	//Hämtar highscore från txt-filen
	public int getScore() {
		try (Scanner highScore = new Scanner(new File(Constants.highScoreFile));) 
		{

			return  highScore.nextInt();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
	}

	//Updaterar poängen från txtfilen om nuvarande poäng är högre än förgående poäng.
	public void updateScore() {
		int high = getScore();
		int score = game.getPlayer().getScore();
		if (score > high) 
		{

			try (PrintWriter hc = new PrintWriter(Constants.highScoreFile)) 
			{
				hc.println(score);
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
	}
}