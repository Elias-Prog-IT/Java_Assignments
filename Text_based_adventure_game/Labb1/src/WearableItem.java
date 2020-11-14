/**
*
* WearableItem abstract Class
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/02/2017
* @version 1.0
* 
*/
public abstract class WearableItem extends Item implements Commandable{
    private String description;
    private int sum;
    private int health;
    
    public WearableItem(double weight, String name, int health, int price)
    {
        super(weight, name, price);
        this.health = health;
    }

    public void setDesc(String s) {
        this.description = s;
    }
    public void setSum(int sum)
    {
        this.sum = sum;
    }
    public void putOn(Player player)
    {
    	if (player.inInventory(this)) 
    	{
    		player.getWornItems().add(this);
    		player.setHealth(this.getHealth());
    		player.getInventory().remove(this);
		}
    }
	
	public abstract boolean doCommand(Player player, String command);
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
}