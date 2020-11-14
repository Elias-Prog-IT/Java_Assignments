/**
*
* Human Class
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/02/2017
* @version 1.0
* 
*/
public abstract class Human extends NPC{
	
	public Human(String name, int health, Item item)
	{
		super(name, health, item);	
	}
	
	public abstract boolean doCommand(Player player, String command);

}
