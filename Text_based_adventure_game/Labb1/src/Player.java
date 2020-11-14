import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
/**
*
* Player Class
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/02/2017
* @version 1.0
* 
*/
public class Player implements Commandable {
	// Variabler
	Scanner in = new Scanner(System.in);
	private String[] splitStr;
	private String pName = " ";
	// private Position Location;
	private int gold;
	private int health;
	private int attackDamage;
	private Location curentLocation;

	private ArrayList<Item> inventory = new ArrayList<Item>();
	private ArrayList<Item> wornItems = new ArrayList<>();

	// Players konstruktor
	public Player() 
	{
		System.out.println("Welcome to the adventure game!");
		System.out.println("Please type in your name:");
		this.pName = in.nextLine();
		this.health = 10;
		this.attackDamage = 5;
		this.gold = 10;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold += gold;
	}

	// Metoden skriver ut inventory, via metoden printYourself
	public void printInventory() {
		System.out.println("You have the following items: ");

		for (int i = 0; i < inventory.size(); i++) {
			inventory.get(i).printYourself();
		}

	}

	public ArrayList<Item> getWornItems() {
		return this.wornItems;
	}

	// Lägger till saker i inventory, inventory är en arraylist
	public void addToInventory(Item items) {

		inventory.add(items);
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}

	public Boolean isWorn(Item item) {
		for (Item wornItem : this.wornItems) {
			if (wornItem == item) {
				return true;
			}
		}
		return false;
	}

	public Boolean inInventory(Item item) {
		for (Item invItem : this.inventory) {
			if (invItem == item) {
				return true;
			}
		}
		return false;
	}

	public boolean removeFromInventory(Item item) {
		for (Iterator<Item> iter = this.inventory.iterator(); iter.hasNext();) {
			Item iteratorItem = iter.next();
			if (iteratorItem.equals(item)) {
				iter.remove();
				return true;
			}
			// if (invItem == item)
			// {
			// //this.inventory.contains(item.getName());
			// return this.inventory.remove(item);
			// }
		}
		System.out.println("You don't have this " + item.getName());
		return false;
	}

	public String getName() {
		return pName;
	}

	public void setName(String pName) {
		this.pName = pName;
	}

	// Skickar tillbaka spelarens nuvarande plats
	public Location getLocation() {
		return curentLocation;
	}

	public void setLocation(Location location) {
		if (location != null) {
			curentLocation = location;
		}
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health += health;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage += attackDamage;
	}

//	public void playerActions() {
//
//	}

	public void playerStatus() {
		System.out.println("Your current status is:");
		System.out.println(this.getHealth() + " health");
		System.out.println(this.getAttackDamage() + " damage");
		System.out.println(this.getGold() + " gold \n");
	}

	// Players doCommand, här har vi också problem med fullständig uppräkning
	// light torch, dig osv, borde göras av items själva, enligt kursassistenter
	public boolean doCommand(Player player, String command) {
		//splitStr = command.split(" ");

		switch (command) {

		case "status":
			playerStatus();
			return true;
		
		case "items":
			this.printInventory();

			return true;
		default:
			for (Item item : this.inventory) {
				if (item.doCommand(player, command)) {
					return true;
				} else {
					return false;
				}
			}
			for (Item item : this.wornItems) {
				if (item.doCommand(player, command)) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
}