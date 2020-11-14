/**
*
* Spear Class
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/02/2017
* @version 1.0
* 
*/
public class Spear extends Weapon
{

	public Spear(double weight, String name, int price, int damage) {
		super(weight, name, price, damage);
		// TODO Auto-generated constructor stub
	}


	public void itemPick(Player player)
	{
		if (player.inInventory(this))
		{
			player.setAttackDamage(this.getDamage());
			player.removeFromInventory(this);
		}
	}

	public boolean doCommand(Player player, String command)
	{
		switch(command)
		{
		case "use spear":
			if (player.inInventory(this)) {
				this.putOn(player);
			}
			return true;
		}
		
		return false;
	}
}