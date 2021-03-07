/**
 * 
 * @author Elias Posluk 
 * Student-id:(tuc.elias.posluk)
 * @date 07/03/2021
 * Individuell uppgift
 * Product.java
 * Kurs: Programmering för testare 
 * TUC Yrkeshögskola - Mjukvarutestare
 * 
 */

package automat;

interface Products 
{

	//returnerar en beskrivning av produkten
	public String Description();
	
	//Boolean för köp av produkt. Returnerar true om köpet har gått igenom
	//Returnerar annars false om köpet inte har gått igenom.
	//datatypen double för money är mängden pengar som finns i automaten.
	public boolean Buy(double money);
	
	//Skriver ut hur man kan använda specifik produkt.
	//exempel: "Du dricker Coca-cola, så läskande!
	public void Use();
	
}