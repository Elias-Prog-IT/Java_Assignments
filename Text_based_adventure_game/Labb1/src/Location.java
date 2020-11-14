import java.util.ArrayList;

/**
*
* Location Class
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/02/2017
* @version 1.0
* 
*/
public abstract class Location implements Commandable {
	// Variabler
	private String locName = " ";
	private String longDesc = " ";
	private String shortDesc = " ";
	private ArrayList<Item> itemsHere = new ArrayList<>();
	private NPC npc;
	private boolean colombus = false;

	// Arraylist
	private ArrayList<Location> nearbyLocations = new ArrayList<Location>();
	private ArrayList<String> roads = new ArrayList<String>();

	// Konstruktor till Location klassen som kommer ärvas vidare till
	// subklasserna
	public Location(String locName, String longDesc, String shortDesc, Item items, NPC npc) {
		this.locName = locName;
		this.longDesc = longDesc;
		this.shortDesc = shortDesc;
		this.itemsHere.add(items);
		this.npc = npc;

	}

	public boolean isColombus() {
		return colombus;
	}

	public void setColombus(boolean colombus) {
		this.colombus = colombus;
	}

	// Här sätts location och vägarna som går till varje plats "Connections"
	public void setLocations(Location loc, String road) {
		this.nearbyLocations.add(loc);
		this.roads.add(road);
	}

	// Skriver ut vart det är mökligt att gå
	public void possibleActions() {
		itemCheck();
		npcCheck();
		for (String road : this.roads) {
			if (road != null) {
				System.out.println("There is a road leading " + road + '.');
			}
		}
		System.out.println("What do you want to do? ");
	}

	public void npcCheck() // Skriver ut om det finns en NPC på nuvarande
	{						// spelarens plats.
		if (this.npc != null) {
			System.out.println("There is  a " + npc.getName() + " blocking your path");
		}

	}

	public boolean checkNpc() // Kollar om det finns NPC på nuvarande plats
	{
		if (this.npc != null) {
			return true;
		}
		return false;
	}

	public void npcIsKilled() // Om NPC är dödad så tas den bort från nuvarande
	{							// plats, och under hela processens gång.
		npc = null;
	}

	public NPC getNpc() {
		return npc;
	}

	public void setNpc(NPC npc) {
		this.npc = npc;
	}

	public String getName() {
		return locName;
	}

	public void setName(String locName) {
		this.locName = locName;
	}

	public String getShortDescription() {
		return shortDesc;
	}

	public void setShortDescription(String description) {
		this.shortDesc = description;
	}

	public String getLongDescription() {
		return longDesc;
	}

	public void setLongDescription(String description) {
		this.longDesc = description;
	}

	public void describeYourself() // Här kollar vi om spelaren har varit på
	{ 							  // nuvarande plats eller inte, "colombus" är satt som false innan längst upp, och den indikerar
		if (this.colombus == false)// Om spelaren har varit på platsen innan
		{										// eller ej, så ska den veta vilken form av		
			System.out.println(this.longDesc);	// description den ska skriva ut. 
			colombus = true;
		} else if (this.colombus == true) {
			System.out.println(this.shortDesc);
		}
	}

	public Location getNextLocation(String command) // Här har vi numreringen på
	// väderstrecken
	{
		switch (command) {
		case "north":
			return this.nearbyLocations.get(0);
		case "east":
			return this.nearbyLocations.get(1);
		case "south":
			return this.nearbyLocations.get(2);
		case "west":
			return this.nearbyLocations.get(3);
		}
		return null;
	}

	// Här kollar vi om det finns en Item på den nuvarande platsen vi står på.
	public void itemCheck() {
		if (itemsHere != null) {
			for (Item item : this.itemsHere)
				System.out.println("There is  a " + item.getName() + " on the ground");
		}
	}

	public void addToInventory(Player player, String command) {
		this.printItemsHere();
		for (Item item : this.itemsHere) {
			if (command.contains(item.getName())) {
				player.addToInventory(item);
				System.out.println("You have added " + item.getName() + " to your inventory!");
				player.getLocation().itemsHere.clear();
				return;
			}
		}
		System.out.println("That item is not here...");
	}

	public void printItemsHere() 
	{
		for (Item item : itemsHere) 
		{
			//	System.out.println(item.getName());
		}
	}

	public void playerHint(String command) 
	{
		if (command.equals("help")) 
		{
			System.out.println("You can move around by typing north/south/west/east.");
			System.out.println("You can also pick up items by typing in 'take' + [Item name]. \n" 
					+ "You can use whatever you have picked up by typing 'use' [Item name] or 'wear' [wearable item name] \n"
					+ "Lastly, you can type in 'status' to check your current health, attack damage and how much gold you have. \n");
		}
	}

	// Här här Locations doCommand metod. Här tar vi in våran command som är
	// spelarens input och kollar om
	// Den strängen/datan stämmer överens med en utav de case-satserna.
	public boolean doCommand(Player player, String command) {
		String[] stringSplit;
		stringSplit = command.split(" ");

		switch (stringSplit[0]) {
		case "north":
		case "east":
		case "south":
		case "west":
			player.setLocation(this.getNextLocation(command));
			return true;
		case "take":
			this.addToInventory(player, command);
			return true;
		default: // Om spelaren skriver help så ska man få en liten beskrivning
			// om hur man ska spela.
			if (this.npc != null && this.npc.doCommand(player, command)) // Här kollar vi så länge den npc på platsen inte är nullad  
			{
				return true;
			} 
			else 
			{
				playerHint(command);
				return false;
			}
		}
	}
}