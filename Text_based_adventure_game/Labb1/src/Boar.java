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

	//H�r ska "kill boar" commanden finnas och inte i Player klassen. alghoritmen, mm ska finnas h�r och ej i Player klassen
	public boolean attack(Player player, String command, Item item)
	{
		if (player.getLocation().checkNpc() && player.getLocation().getNpc().getName().equals("boar")) 
		{	
			for (int i = 0; i < player.getInventory().size(); i++) //Om spelaren har spear i hans inventory eller b�r p� den, s� kommer han lyckas att d�da boaren
			{
				//TODO komplettering: den h�r raden kraschade i IndexOutOfBoundsException
				//jag tror problemet �r att ni gettar i WornItems p� plats i, utan att ha f�rs�krat er om att
				//index i finns i den arraylisten (ni har f�rs�krat er om att den finns i inventory-arraylisten)
				if (player.getInventory().get(i).getName().equals("spear") || player.getWornItems().get(i).getName().equals("spear"))
					//kommentar: ni kanske kan fr�ga spelaren lite sn�llt om hen har en spear, ist�llet f�r att gr�va runt i dennes ryggs�ck
				{
					System.out.println("The boar charges at you! \n" 
							+ 	"Luckily you have your spear, you would not have survived the attack without it." );

					player.getLocation().npcIsKilled();
					return true;
				}

			}
			if (player.inInventory(item) == false) // Om spelaren inte har spear i hans inventory s� kommer spelaren att antingen d� och spelet avslutas, 
			{										//eller skadas, d� kommer spelet att forts�tta.		
				System.out.println("You don't have a spear in your inventory!");
				player.setHealth(-10);
				System.out.println("You take 10 damage, your health is: " + player.getHealth());

				if (player.getHealth() <= 0)
				{
					System.out.println("You Died");
					System.exit(0);	//lite fr�ckt att g�ra det h�r l�ngt nere i en klass, ist�llet f�r att l�ta spel-loopen sk�ta avslutandet
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
			attack(player,command,null); //varf�r skicka med kommandot? Det kommer ju alltid vara exakt samma str�ng?
			return true;
		}
		return false;
	}
}