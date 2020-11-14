/**
*
* Weapons abstract Class
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/02/2017
* @version 1.0
* 
*/
public abstract class Weapon extends Item implements Commandable
{
	private int damage;
	public Weapon(double weight, String name, int price, int damage) 
	{
		super(weight, name, price);
		this.damage = damage;
	}
	
	public int getDamage() 
	{
		return damage;
	}
	public void setDamage(int damage) 
	{
		this.damage = damage;
	}
	//Här ska doCommand skicka vidare till subklassen Spear. 
	public void putOn(Player player) {
		System.out.println("You are now weilding the "+ this.getName() +'!');		
		player.getWornItems().add(this);
		player.setAttackDamage(this.getDamage());
		player.getInventory().remove(this);
		System.out.println("end of method");
	}
	
	public abstract boolean doCommand(Player player, String command);
}