/**
 * 
 * @author Elias Posluk 
 * Student-id:(tuc.elias.posluk)
 * @date 07/03/2021
 * Individuell uppgift
 * Clothing.java
 * Kurs: Programmering för testare 
 * TUC Yrkeshögskola - Mjukvarutestare
 * 
 */
package automat;

public class Clothing extends Items
{

	//Konstruktor för klassen Clothing, som har super från den abstrakta klassen Items.
	public Clothing(String name , String useMessage, double productPrice, String description) 
	{
		super(name, productPrice, useMessage, description);
		
	}

	//returnerar en beskrivning av produkten kläder
	public String Description() 
	{
		return description;
	}

	//returnerar sant om det finns tillräckligt med pengar i maskinen
	public boolean Buy(double money) 
	{
		if(money >= productPrice) 
		{
			return true;
		}
		return false;
	}

	//skriver ut hur man använder kläderna
	public void Use() 
	{
		System.out.println(useMessage);
	}

	@Override
	public String toString() 
	{
		return name;
	}
	
}
