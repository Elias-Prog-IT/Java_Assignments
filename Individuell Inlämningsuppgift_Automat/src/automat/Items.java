/**
 * 
 * @author Elias Posluk 
 * Student-id:(tuc.elias.posluk)
 * @date 07/03/2021
 * Individuell uppgift
 * Items.java
 * Kurs: Programmering för testare 
 * TUC Yrkeshögskola - Mjukvarutestare
 * 
 */
package automat;

 public abstract class Items implements Products
{
	//Beskriver produkten
	protected String description;
	
	//lagrar priset på en produkt
	protected double productPrice;
	
	//Beskriver hur man användar produkten
	protected String useMessage;
	
	//lagrar produktens namn
	protected String name;
	
	
	public Items(String name, double productPrice, String description, String useMessage)
	{
		this.name = name;
		this.description = description;
		this.productPrice = productPrice;
		this.useMessage = useMessage;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	
}
