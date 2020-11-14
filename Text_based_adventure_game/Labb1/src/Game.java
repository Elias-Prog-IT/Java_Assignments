import java.util.ArrayList;
import java.util.Scanner;

//Allmänna kommentarer:
//Verkligen mycket bra kommenterat!
//Ni har löst doCommand-strukturen mycket bra!

/**
*
* Game Class
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/02/2017
* @version 1.0
* 
*/
public class Game 
{
	
	//TODO komplettering: ange alltid synlighet
	Scanner in = new Scanner(System.in);
	boolean running = true;

	private Player player;

	private Location[] World = new Location[5];

	Location[] paths = new Location[4];
	Location[] room = new Location[4];
	
	//TODO komplettering: varför har ni lagt alla de strängarna ute i klassen? Behövs det?
	//och varför är de konstanta?
	final String P = "Plains"; // Plains, Woods, Mountains, mm är namnen på
								// platserna som ska skrivas ut
	final String W = "Woods"; // beroende på vart man befinner sig i världen.
	final String M = "Mountains";
	final String D = "Desert";
	final String S = "Swamp";

	// LongDesc skrivs bara ut 1 gång, om du har inte har varit på platsen
	// innan.
	final String longDescP = "You are standing in the middle of a plain.\nIt seems to go on for miles "
			+ "and miles. You cannot remember how you got here and you have nothing but the clothes on you.\n"
			+ "Way out in the distance to the north you see some woods. Over to the east you see some mountains.\n";

	final String longDescW = "You are standing at the edge of the Woods. The thick rows of trees seems to go on for miles.\n"
			+ "To the west you see some wetlands ";

	final String longDescM = "A tall moutain range is standing before you. The peaks seems to go on forever,\n"
			+ "disappearing in the clouds. You walk in to a cave. To the south a desert is visibe.";

	final String longDescD = "A desert spreads out before you. The sand is almost scorching your feet.\n"
			+ " To the north the endless plains is the only thing visible.";

	final String longDescS = "An amlost rotten stench spreads out before you. The swamp sees ominous, almost living.\n "
			+ "To the north a vast forest is visible.";

	// shortDescription skrivs ut bara om du har befunnit dig på platsen förut.
	final String shortDescP = "You're back on the plains again";
	final String shortDescW = "You're back in the Woods again";
	final String shortDescM = "You're up in the cave in the Mountains again";
	final String shortDescD = "You're back in the scorching hot Desert again";
	final String shortDescS = "You're back in the wetland Swamps again";

	ArrayList<Commandable> commandableObjects = new ArrayList<>();

	// Run metoden körs i Game konstruktorn.
	public Game() {
		// Item Skapas här med värden.
		Item shovel = new Shovel(2.1, "shovel", 100);
		Item elven_robe = new ElvenRobe(3.0, "elven_robe", 50, 200);
		Item torch = new Torch(1, "torch", 50);
		Item spear = new Spear(10.0, "spear", 10, 10);
		Item shoes = new Shoes(1.5, "shoes", 20, 100);

		// NPC skapas här med namn, och liv, dessa har inga items "null"
		NPC boar = new Boar("boar", 20, null);
		NPC beggar = new Beggar("beggar", 10, null);

		boolean running = true;

		// Platserna i världen skapas här, tillhörande specifik subklass. Alla
		// platser har "False" som betyder att
		// spelaren har inte varit på platsen än. Alla platser har en specifik
		// Item samt NPC.
		Location plains = new OutDoorsArea(P, longDescP, shortDescP, false, shovel, null);
		Location woods = new OutDoorsArea(W, longDescW, shortDescW, false, spear, boar);
		Location swamp = new OutDoorsArea(S, longDescS, shortDescS, false, elven_robe, null);
		Location desert = new OutDoorsArea(D, longDescD, shortDescD, false, shoes, beggar);
		Location mountains = new Room(M, longDescM, shortDescM, false, torch, null);

		// I World lagras alla platser, den gör inget mer.
		Game.this.World[0] = plains;
		Game.this.World[1] = woods;
		Game.this.World[2] = swamp;
		Game.this.World[3] = desert;
		Game.this.World[4] = mountains;

		// Här sätter vi möjliga platser att gå till från en location eller där
		// nuvarande spelaren "står"
		// Områderna som är satta till "null" är platser som inte har någon
		// "väg" mellan varandra.
		plains.setLocations(woods, "north");
		plains.setLocations(mountains, "east");
		plains.setLocations(desert, "south");
		plains.setLocations(swamp, "west");

		woods.setLocations(null, null);
		woods.setLocations(null, null);
		woods.setLocations(plains, "south");
		woods.setLocations(swamp, "west");

		swamp.setLocations(woods, "north");
		swamp.setLocations(plains, "east");//
		swamp.setLocations(null, null);
		swamp.setLocations(null, null);

		desert.setLocations(plains, "north");//
		desert.setLocations(mountains, "east");
		desert.setLocations(null, null);
		desert.setLocations(null, null);

		mountains.setLocations(null, null);
		mountains.setLocations(null, null);
		mountains.setLocations(desert, "south");
		mountains.setLocations(plains, "west");

		// Spelaren skapas samt kallar på metoden getname för att kunna skriva
		// in spelarens namn.
		// Spelaren börjar alltid på mitten av "kartan" eller "världen" som
		// heter "plains"
		player = new Player();
		player.getName();
		player.setLocation(plains);
		commandableObjects.add(player);
		commandableObjects.addAll(player.getInventory());
		commandableObjects.add(player.getLocation());
		Run();

	}

	// Alla Commands som spelaren skriver in skickas vidare till nextAction
	// metoden som skickar vidare
	// informationen till varje klass skickas till doCommand metoder, för att
	// kolla om det man skriver in stämmer överens med
	// någon av de Switch-case satserna i doCommand metoderna.
	public void nextAction(String command) {
		this.updateComList(player);
		for (Commandable comObject : this.commandableObjects) {
			if (comObject.doCommand(player, command)) {
				break;
			}
		}
	}

	//väldigt snygg lösning
	public void updateComList(Player player) {
		//this.commandableObjects.remove(this.commandableObjects.size()-1);
		//this.commandableObjects.add(player.getLocation());
		commandableObjects = new ArrayList<Commandable>();
		commandableObjects.add(player);
		commandableObjects.addAll(player.getInventory());
		commandableObjects.add(player.getLocation());
		
	}

	public void Run() {

		// Spelet körs innanför while-loopen.
		while (running) {
			String command;

			System.out.print('\n');
			System.out.println("Hello " + player.getName() + ", welcome to this magical world of wonder! \n"
					+ "You can move around by typing north/south/west/east. \n"
					+ "You will have to learn more commandsas you play the game! (Hint: there is a command help)"
					+ "\n");

			// Här hämtar vi Spelarens nuvarande plats, med en describeYourself
			// metod som är en boolean, som kollar om
			// Spelaren har varit på platsen innan eller ej. Här kommer
			// kallelsen till longDescription och shortDescription
			// Med överskuggning från OutDoorsArea klassen där den har en
			// describeYourself metod som hanterar vädret.
			player.getLocation().describeYourself();
			player.getLocation().possibleActions();
			command = in.nextLine().toLowerCase();
			this.nextAction(command);

			//kan ni inte hoppa in i den inre while-loopen direkt?
			//så behöver ni inte skriva samma rader två gånger
			
			
			boolean dead = false;

			// Här kallar vi på samma metoder som ovan, under en nästlad
			// while-loop.
			while (!dead) {
				player.getLocation().describeYourself();
				player.getLocation().possibleActions();

				command = in.nextLine().toLowerCase();
				this.nextAction(command);

			}
		}

	}
}