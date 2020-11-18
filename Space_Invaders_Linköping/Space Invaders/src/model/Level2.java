package model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
* Class Level2.java
* 
* Nivå 2 ärver ifrån game klassen.
* 
* Den håller koll på hur många aliens ska ritas ut på nivå 2. 
* Hastigheten på fienden är snabbare
* Den har kvar samma spelare från nivå 1. 
* men tilldelar mer skott för spelaren när spelaren kommer vidare till nivå 2.
* 
*/
public class Level2 extends Game
{
	
	public Level2(Player player) 
	{
		super(Constants.alienSpeedDownlvl2, Constants.alienDx, Constants.alienSpeedDownlvl2);
		try 
		{
			alienGrid = new AlienGrid(Constants.levelTwoAlienRows, Constants.levelTwoCols, ImageIO.read(new File("alien2.png")), Constants.levelTwoAlienPoints);
			this.player = player;
			player.powerUpShots(Constants.ammoOnLevelTwo);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	// slutet av spelet, men man kan bygga vidare med fler banor om så önskas.
	@Override
	public Game next() {
		return null;
	}
}
