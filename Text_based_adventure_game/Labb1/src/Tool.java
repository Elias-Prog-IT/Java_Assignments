/**
*
* Tool Class
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/02/2017
* @version 1.0
* 
*/
public abstract class Tool extends Item {

	public Tool(double weight, String name, int price) {
		super(weight, name, price);
	}

	//denna metod används av shovel och torch klassen. skriver man wear "item"
	public void putOn(Player player) 
	{			
		System.out.println("You are now holding the " + this.getName() + '!');
		player.getWornItems().add(this);
		player.getInventory().remove(this);
	}
	// Här ärver torch och Shovel från Tool klassen. Så doCommand ska skicka
	// vidare commanden till subklasserna Torch och shovel.
	public abstract boolean doCommand(Player player, String command);
}