import java.util.Random;
 
/**
*
* OutDoorsArea Class
* 
* @author Elias Posluk
* @LIU_ID elipo145
* @date   17/02/2017
* @version 1.0
* 
*/
public class OutDoorsArea extends Location
{
 
    public OutDoorsArea(String locName, String longDesc, String shortDesc, boolean b, Item items, NPC npc)
    {
        super(locName, longDesc, shortDesc, items, npc);    


    }
    //Skriver ut väder för location som är outDoorsArea. Denna överskuggar metoden describeyourself i location. 
  @Override
    public void describeYourself()
    {
    	super.describeYourself();
    	String snow = "It's snowing";
    	String rain = "It's raining";
    	String clouds = "It's cloudy";
    	String sun = "It's sunny";
    	String fog = "It's foggy";
    	String cold = "it's cold";
    	
    	Random randomWeather = new Random();
    	int randInt = randomWeather.nextInt(6);//Varje gång du hamnar i samma område eller olika områden så får du olika väder //kul!
    	
    	
    	switch (randInt) 
    	{
    	case 0:
    		System.out.println(snow);
    		break;
    	case 1:
    		System.out.println(rain);
    		break;
    	case 2:
    		System.out.println(clouds);
    		break;
    	case 3:
    		System.out.println(sun);
    		break;
    	case 4:
    		System.out.println(fog);
    		break;
    	case 5:
    		System.out.println(cold);
    		break;
    	}
    }
}