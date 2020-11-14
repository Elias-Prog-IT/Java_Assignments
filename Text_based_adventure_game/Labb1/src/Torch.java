/**
*
* Torch Class
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/02/2017
* @version 1.0
* 
*/
public class Torch extends Tool {

	public Torch(double weight, String name, int price) {
		super(weight, name, price);
		// TODO Auto-generated constructor stub
	}

	public void torchItem(Player player) 
	{
		if (player.getLocation().getName().equals("Mountains")) 
		{
			System.out.println("The light attracts a bat! It attacks you! You lose 5 HP");
			player.setHealth(-5);
			System.out.println("Your current health is " + player.getHealth());
		} 
		else 
		{
			System.out.println("There is no need for light here..");
		}
	}

	public boolean doCommand(Player player, String command) {

		switch (command) {
		case "light torch":
			torchItem(player);
			return true;
			default:
		
		return false;
	}
	}
}