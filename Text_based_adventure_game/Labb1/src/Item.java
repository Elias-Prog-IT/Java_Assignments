/**
*
* Item Class
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/02/2017
* @version 1.0
* 
*/
public abstract class Item  implements Commandable
{
	private double weight;
	private String name;
	private int price;
	boolean digAble = true;

	public Item(double weight, String name, int price)
	{
		this.weight = weight;
		this.name = name;
		this.price = price;
	}
	
	//Här skriver vi ut alla items som vi har plockat upp från världen och lagt i våran inventory. 
	public void printYourself()
	{	
		System.out.print(name + " ");
		System.out.println(" (" + weight + " kg)");	
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//putOn metoden är också abstract som implemeteras i varsin subklass. 
	public abstract void putOn(Player player);
	
	//Här ska vi ha våran "take" command som sedan ska skicka vidare commanden till respektive subklass antingen "torch" klassen, eller "shovel" klassen, 
		//istället för att ha den i location klassen. 
	public abstract boolean doCommand(Player player, String command);

}