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
* Class Level1.java
* 
* Här är spelets första nivå
* 
* Level 1 ärver från Game.java
* 
* Den håller koll på hur många aliens ska ritas ut på nivå 1. 
* Hastigheten på fienden, ritar ut skeppets utseende och sätter spelarens liv och antal skott. 
* 
* Hoppar vidare till nivå 2 om spelaren lyckas få bort alla aliens i nivå 1. 
* 
* 
* 
*/

public class Level1 extends Game {

	//Nivå 1  
	public Level1() {
		super(Constants.alienSpeedDownlvl1, Constants.alienDx, Constants.alienSpeedDownlvl1);
		try 
		{
			alienGrid = new AlienGrid(Constants.levelOneAlienRows, Constants.levelOneCols,
					ImageIO.read(new File("alien1.png")), Constants.levelOneAlienPoints);
			Ship ship = new Ship((Constants.panelWidth - Constants.shipWidh)/2, Constants.panelHeight - Constants.shipHeight, Constants.shipWidh, Constants.shipHeight);
			player = new Player(ship, Constants.playerLives, Constants.ammoOnLevelOne);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	//Går över till nivå två
	@Override
	public Game next() 
	{
		return new Level2(player);
	}
}
