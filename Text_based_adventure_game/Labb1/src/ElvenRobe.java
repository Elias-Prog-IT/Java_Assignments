/**
*
* ElvenRobe Class
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/02/2017
* @version 1.0
* 
*/
public class ElvenRobe extends WearableItem
{

	public ElvenRobe(double weight, String name, int health, int price) 
	{
		super(weight, name, health, price);
		// TODO Auto-generated constructor stub
	}
	
	
	public void wearElvenRobe(Player player)
	{
			if (player.inInventory(this))
			{
				System.out.println("You are now wearing the elven_robe!");
				player.setHealth(this.getHealth());
				player.removeFromInventory(this);
			}
	}
	
	@Override
	public boolean doCommand(Player player, String command)
	{
		switch(command)
		{
		case "wear elven_robe":
			wearElvenRobe(player);
			return true;
		}
		return false;
	}
}