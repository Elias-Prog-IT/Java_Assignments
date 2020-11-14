/**
*
* Beggar Class
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/02/2017
* @version 1.0
* 
*/
public class Beggar extends Human{

	public Beggar(String name, int health, Item item) {
		super(name, health, item);
		// TODO Auto-generated constructor stub
	}
	

	public void give(Player player)
	{

		if (player.getLocation().checkNpc() && player.getLocation().getNpc().getName().equals("beggar")) 
	 	{
	
	 		player.setHealth(+20);
    		player.setGold(-10); 
    		player.getLocation().npcIsKilled();
    		System.out.println("Take this potion, it will heal you!");
    		System.out.println("The potion increased you health to " + player.getHealth());
			
			}
		
	}
	public boolean doCommand(Player player, String command) 
	{	
		switch (command)
		{
		
		case "give coins":
			give(player);
			return true;
		}
		return false;
	} 
}