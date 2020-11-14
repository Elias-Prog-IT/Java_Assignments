/**
*
* Boar Class
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/02/2017
* @version 1.0
* 
*/
public class Boar extends Monster
{

	public Boar(String name, int health, Item item) 
	{
		super(name, health, item);
	}

	//Här ska "kill boar" commanden finnas och inte i Player klassen. alghoritmen, mm ska finnas här och ej i Player klassen
	public boolean attack(Player player, String command, Item item)
	{
		if (player.getLocation().checkNpc() && player.getLocation().getNpc().getName().equals("boar")) 
		{	
			for (int i = 0; i < player.getInventory().size(); i++) //Om spelaren har spear i hans inventory eller bär på den, så kommer han lyckas att döda boaren
			{
				//TODO komplettering: den här raden kraschade i IndexOutOfBoundsException
				//jag tror problemet är att ni gettar i WornItems på plats i, utan att ha försäkrat er om att
				//index i finns i den arraylisten (ni har försäkrat er om att den finns i inventory-arraylisten)
				if (player.getInventory().get(i).getName().equals("spear") || player.getWornItems().get(i).getName().equals("spear"))
					//kommentar: ni kanske kan fråga spelaren lite snällt om hen har en spear, istället för att gräva runt i dennes ryggsäck
				{
					System.out.println("The boar charges at you! \n" 
							+ 	"Luckily you have your spear, you would not have survived the attack without it." );

					player.getLocation().npcIsKilled();
					return true;
				}

			}
			if (player.inInventory(item) == false) // Om spelaren inte har spear i hans inventory så kommer spelaren att antingen dö och spelet avslutas, 
			{										//eller skadas, då kommer spelet att fortsätta.		
				System.out.println("You don't have a spear in your inventory!");
				player.setHealth(-10);
				System.out.println("You take 10 damage, your health is: " + player.getHealth());

				if (player.getHealth() <= 0)
				{
					System.out.println("You Died");
					System.exit(0);	//lite fräckt att göra det här långt nere i en klass, istället för att låta spel-loopen sköta avslutandet
				}
			}
		}
		return false;
	}

	public boolean doCommand(Player player, String command) 
	{
		switch(command) 
		{
			case "kill boar":
			attack(player,command,null); //varför skicka med kommandot? Det kommer ju alltid vara exakt samma sträng?
			return true;
		}
		return false;
	}
}