/**
*
* Monster Class
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/02/2017
* @version 1.0
* 
*/
public abstract class Monster extends NPC{
	
	public Monster(String name, int health, Item item){
		
		super(name, health, item);
		
	}

	//Denna klassen är en super till boar klassen, som ska skicka vidare commanden till boar.

	public abstract boolean doCommand(Player player, String command) ;
}