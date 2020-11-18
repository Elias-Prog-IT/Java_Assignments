package util;
/**
*
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/03/2017
* @version 1.0
* Course: 725G91 Object oriented programming in Java
* Linköping University
* 
* Class Constants.java
* 
* Konstanter för att styra spelet.
* 
*/

public interface Constants 
{

	String highScoreFile = "highscores.txt";
	
	int alienHeight = 32, alienWidth = 32;
	int shipHeight = 32, shipWidh = 32;
	int fireHeight = 16, fireWidth = 8;
	int panelHeight = 512, panelWidth = 520;

	int playerLives = 3;
	int levelOneAlienRows = 3, levelOneCols = 10;
	int levelTwoAlienRows = 4, levelTwoCols = 10;
	int levelOneAlienPoints = 10, levelTwoAlienPoints = 20;
	int ammoOnLevelOne = 40, ammoOnLevelTwo = 45;
	int extraAmmoPowerUp = 20;
	int fireSpeed = 50, fireDx = 3;
	int alienSpeedDownlvl1 = 1000, alienSpeedDownlvl2 = 500, alienDx = 10;
	int alienSpeedSideWayslvl1 = 1000, alienSpeedSideWayslvl2 = 200;
}
