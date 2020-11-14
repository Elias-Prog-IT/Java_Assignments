/**
*
* Shovel Class
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/02/2017
* @version 1.0
* 
*/
public class Shovel extends Tool 
{
	
	public Shovel(double weight, String name, int price) 
	{
		super(weight, name, price);
	}


	private boolean checkShovel(Player player) // Kollar om man har "equipped" shoveln innan man kan börja gräva
	{	
		 if (!(player.isWorn(this)))
         {
			System.out.println("You haven't equipped yourself with the shovel!");
            return true;
         }
		 else
		 {
			 return false;
		 }
	}

	public void shovelDig(Player player)
	{
		 checkShovel(player); // Kallar på metoden ovanför först
		
		 for (int i = 0; i < player.getWornItems().size(); i++) 
		{
			
			if (player.getLocation().getName().equals("Mountains")) //Kollar om spelaren är på "mountains", då ska man inte kunna gräva på platsen
			{
				System.out.println("You can't dig here!");
			} 
			else if(player.getWornItems().get(i).getName().equals("shovel")) 
			{
				System.out.println("You have dug a hole!");
			}
		}
	}

	@Override
	public boolean doCommand(Player player, String command)
	{
		switch(command)
		{
		case "use shovel": 
			if (player.inInventory(this)) 
			{
				this.putOn(player); // kallar på metoden i abstrakta klassen i tools
			}
			return true;
		case "dig":
			shovelDig(player);
			return true;
		}
		return false;
	}
}	