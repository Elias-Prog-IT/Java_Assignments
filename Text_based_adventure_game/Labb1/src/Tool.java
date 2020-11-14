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

	//denna metod anv�nds av shovel och torch klassen. skriver man wear "item"
	public void putOn(Player player) 
	{			
		System.out.println("You are now holding the " + this.getName() + '!');
		player.getWornItems().add(this);
		player.getInventory().remove(this);
	}
	// H�r �rver torch och Shovel fr�n Tool klassen. S� doCommand ska skicka
	// vidare commanden till subklasserna Torch och shovel.
	public abstract boolean doCommand(Player player, String command);
}