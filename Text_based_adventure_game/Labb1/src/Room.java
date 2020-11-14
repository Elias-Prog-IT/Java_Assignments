/**
*
* Room Class
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/02/2017
* @version 1.0
* 
*/

public class Room extends Location
{
	private int size;

	public Room(String locName, String longDesc, String shortDesc, boolean b, Item items, NPC npc) {
		super(locName, longDesc, shortDesc, items, npc);
	}


	private int getSize()
	{
		return size;
	}

	public void setSize(int size)
	{
		this.size = size;

	}
}