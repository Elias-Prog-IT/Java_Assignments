/**
 * 
 * @author Elias Posluk 
 * Student-id:(tuc.elias.posluk)
 * @date 07/03/2021
 * Individuell uppgift
 * Food.java
 * Kurs: Programmering f�r testare 
 * TUC Yrkesh�gskola - Mjukvarutestare
 * 
 */

package automat;

public class Food extends Items
{
	//Konstruktor f�r klassen Food, som har super fr�n den abstrakta klassen Items.
	public Food(String name, String useMessage, double productPrice, String description)
	{
		super(name, productPrice, useMessage, description);
		
	}
	
	//returnerar en beskrivning av dryckesvara
	public String Description() 
	{
		return description;
	}

	//returnerar sant om det finns tillr�ckligt med pengar i maskinen
	public boolean Buy(double money) 
	{
		if(money >= productPrice) 
		{
			return true;
		}
		return false;
	}

	//skriver ut hur man anv�nder maten
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
