/**
*
* Shoes Class
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/02/2017
* @version 1.0
* 
*/

public class Shoes extends WearableItem
{

	public Shoes(double weight, String name, int health, int price) {
		super(weight, name, health, price);
		// TODO Auto-generated constructor stub
	}


	public void itemPick(Player player)
	{
		if (player.inInventory(this))
		{
			System.out.println("You have put on the shoes! ");
			player.setHealth(this.getHealth());
			player.removeFromInventory(this);
		}
	}
	
	@Override
	public boolean doCommand(Player player, String command) {
		switch(command)
		{
		case "wear shoes":
			this.putOn(player);
		return true;
		}
		return false;
	}
	
	

}