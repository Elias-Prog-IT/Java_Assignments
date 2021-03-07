/**
 * 
 * @author Elias Posluk 
 * Student-id:(tuc.elias.posluk)
 * @date 07/03/2021
 * Individuell uppgift
 * Product.java
 * Kurs: Programmering f�r testare 
 * TUC Yrkesh�gskola - Mjukvarutestare
 * 
 */

package automat;

interface Products 
{

	//returnerar en beskrivning av produkten
	public String Description();
	
	//Boolean f�r k�p av produkt. Returnerar true om k�pet har g�tt igenom
	//Returnerar annars false om k�pet inte har g�tt igenom.
	//datatypen double f�r money �r m�ngden pengar som finns i automaten.
	public boolean Buy(double money);
	
	//Skriver ut hur man kan anv�nda specifik produkt.
	//exempel: "Du dricker Coca-cola, s� l�skande!
	public void Use();
	
}