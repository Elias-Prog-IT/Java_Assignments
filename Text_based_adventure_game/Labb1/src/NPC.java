/**
*
* NPC Class
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/02/2017
* @version 1.0
* 
*/
public abstract class NPC implements Commandable 
{
	
	private String name;
	private int health;
	private Item item;
		
	public NPC(String name, int health, Item item) 
	{
		this.setName(name);
		this.health = health;
		this.item = item;
	}
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	
	public abstract boolean doCommand(Player player, String command) ;
}