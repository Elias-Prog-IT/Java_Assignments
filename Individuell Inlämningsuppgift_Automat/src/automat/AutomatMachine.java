/**
 * 
 * @author Elias Posluk 
 * Student-id:(tuc.elias.posluk)
 * @date 07/03/2021
 * Individuell uppgift
 * AutomatMachine.java
 * Kurs: Programmering för testare 
 * TUC Yrkeshögskola - Mjukvarutestare
 * 
 */

package automat;

import java.util.Scanner;

public class AutomatMachine 
{

	public static void main(String[] args) 
	{
	//scanner för användarinput till automaten
	Scanner s = new Scanner(System.in);
	
	//För att spara användarinput
	String input;
	
	//Avslutar loopen på menyn och programmet
	boolean exit = false;
	
	//flagga som används i den nästlade loopen
	boolean flag = true;
	
	// wallet (plånboken) innehåller den summa pengar användaren har
	// I stigande ordning så är index 0 för 1 krona, index 2 är för 5 kr, osv..
	int[] wallet = {10, 10, 10, 10};
			
	//Mängden pengar som är i automaten, den startar från värdet noll.
	double money = 0;
	
	//Initialiserar produkternas objekt.
	Clothing shirt = new Clothing("T-shirt", "Vit T-shirt.", 50.0,  "En bekväm T-shirt, som du tar på dig.");
	Clothing pants = new Clothing("Byxor", "Diesel jeans.", 105.0,  "Nya och snygga jeans.");
	Clothing hat = new Clothing("Mössa", "Brun Mössa.", 25.0,  "Mössan framhäver dina ögon och värmer dina öron.");
	Food kexchoklad = new Food("Kexchoklad", "Kexchoklad med tre lager frasiga chokladöverdragna rån.", 10.0,  "MMMMM..Frasig!");
	Food potatoChips = new Food("Chips", "Saltade potatischips.", 18.0,  "MUMS! Bra snacks som går bra med en läskande dryck!");
	Food granolaBar = new Food("GranolaBar", "Granolabar med chokladöverdrag.", 15.0,  "MUMS! Få extra energi under dagen!");
	Drink water = new Drink("Ramlösa", "Ramlösa med mango smak.", 20.0,  "Slurp! Uppfriskande!");
	Drink sprite = new Drink("Sprite", "Sprite med ton av citron.", 28.0,  "Slurp! Smaskens!");
	Drink cocaCola = new Drink("Coca-Cola", "Coca-Cola Zero, utan socker.", 30.0,  "Slurp! Kan du känna skillnaden?");
	
	
	/*  Menyval i while-loopen:
	 *   s - (select) för att se beskrivningen på produkten och valet att köpa produkten
	 *   i - (insert) insättning av pengar till maskinen.
	 *   w - (withdraw) Uttag av antingen hela beloppet eller kvarvarande summan efter köp
	 *   e - (exit) Avslutar programmet och körningen.
	 */
	while(!exit) {
		//Skriver ut menyn 
		System.out.println("\n* * * * * * * * * * * * * * * Allt Möjligt Automaten! * * * * * * * * * * * * * ");
		System.out.println("*                                                                             *");
		System.out.printf("* %19s] A1%19s] A2%19s] A3       *\n", "[" + shirt + " " + shirt.productPrice + "kr",  "[" + pants+ " " +pants.productPrice + "kr", "[" + hat  + " " + hat.productPrice + "kr");
		System.out.printf("* %19s] B1%19s] B2%19s] B3       *\n", "[" + kexchoklad + " " + kexchoklad.productPrice + "kr", "[" + potatoChips + " " + potatoChips.productPrice + "kr", "[" + granolaBar + " " + granolaBar.productPrice + "kr");
		System.out.printf("* %19s] C1%19s] C2%19s] C3       *\n", "[" + water + " " + water.productPrice + "kr", "[" + sprite + " " + sprite.productPrice + "kr", "[" + cocaCola + " " +  cocaCola.productPrice + "kr");
		System.out.println("*                                                                             *");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println("Insatta pengar i automaten:" + " " +  money + "kr");
		printWallet(wallet);
		System.out.println("\nMeny: 's' Välj en produkt | 'i' pengar insättning | 'w' pengar uttag/retur | 'e' för att avsluta/exit");
		System.out.print("Urval: ");
	
	
		//Hämtar användarinmatning
		input = s.next().toLowerCase();
		
		//Kontrollerar användarinmatningen 
		if(input.equals("s")) { 
			
			while(flag) {
				System.out.print("\nAnge koden för den produkt du vill ha: ");
				input = s.next().toLowerCase();
				//tempvariabeln sparar värdet på den valda produkten, om användaren köper produkten.
				String temp = input;
				//validerar produktnamnet
				if(!productValidate(input)) {
					System.out.println("Ange en giltig produktkod");
				} else {
					//skriver ut beskrivningen på produkterna.
					if(temp.equals("a1")) {
						System.out.println("\nProduktbeskrivning: " + shirt.Description());
					} else if(temp.equals("a2")) {
						System.out.println("\nProduktbeskrivning: " + pants.Description());
					} else if(temp.equals("a3")) {
						System.out.println("\nProduktbeskrivning: " + hat.Description());
					} else if(temp.equals("b1")) {
						System.out.println("\nProduktbeskrivning: " + kexchoklad.Description());
					} else if(temp.equals("b2")) {
						System.out.println("\nProduktbeskrivning: " + potatoChips.Description());
					} else if(temp.equals("b3")) {
						System.out.println("\nProduktbeskrivning: " + granolaBar.Description());
					} else if(temp.equals("c1")) {
						System.out.println("\nProduktbeskrivning: " + water.Description());
					} else if(temp.equals("c2")) {
						System.out.println("\nProduktbeskrivning: " + sprite.Description());
					} else if(temp.equals("c3")) {
						System.out.println("\nProduktbeskrivning: " + cocaCola.Description());
					}
					
					//Användaren får möjligheten att köpa produkten, när användaren befinner sig i beskrivningsdelen till produkten.
					System.out.println("Skulle du vilja...\n(k) - Köpa produkten \n(r) - returnera till menyn");
					input = s.next().toLowerCase();
					//om användaren välkher alternativet "k" så kontrolleras om man kan köpa produkten.
					if(input.equals("k")) {
						if(temp.equals("a1")) {
							//om automaten har tillräckligt med pengar för att köpa produkten.
							if(shirt.Buy(money) == true) {
								//Uppdaterar pengarna som är kvar i automaten och tipsar om hur man kan använda produkten.
								shirt.Use();
								money = money - shirt.productPrice;
							} else {
								//Om automaten inte har tillräckligt med pengar, så skriver automaten ut en felmeddelande.
								System.out.println("\nOj, ett fel uppstod: Det finns inte tillräckligt med pengar i automaten!\n");
							}
						} else if(temp.equals("a2")) {
							if(pants.Buy(money) == true) {
								pants.Use();
								money = money - pants.productPrice;
							} else {
								System.out.println("\nOj, ett fel uppstod: Det finns inte tillräckligt med pengar i automaten!\n");
							}
						} else if(temp.equals("a3")) {
							if(hat.Buy(money) == true) {
								hat.Use();
								money = money - hat.productPrice;
							} else {
								System.out.println("\nOj, ett fel uppstod: Det finns inte tillräckligt med pengar i automaten!\n");
							}
						} else if(temp.equals("b1")) {
							if(kexchoklad.Buy(money) == true) {
								kexchoklad.Use();
								money = money - kexchoklad.productPrice;
							} else {
								System.out.println("\nOj, ett fel uppstod: Det finns inte tillräckligt med pengar i automaten!\n");
							}
						} else if(temp.equals("b2")) {
							if(potatoChips.Buy(money) == true) {
								potatoChips.Use();
								money = money - potatoChips.productPrice;
							} else {
								System.out.println("\nOj, ett fel uppstod: Det finns inte tillräckligt med pengar i automaten!\n");
							}
						} else if(temp.equals("b3")) {
							if(granolaBar.Buy(money) == true) {
								granolaBar.Use();
								money = money - granolaBar.productPrice;
							} else {
								System.out.println("\nOj, ett fel uppstod: Det finns inte tillräckligt med pengar i automaten!\n");
							}
						} else if(temp.equals("c1")) {
							if(water.Buy(money) == true) {
								water.Use();
								money = money - water.productPrice;
							} else {
								System.out.println("\nOj, ett fel uppstod: Det finns inte tillräckligt med pengar i automaten!\n");
							}
						} else if(temp.equals("c2")) {
							if(sprite.Buy(money) == true) {
								sprite.Use();
								money = money - sprite.productPrice;
							} else {
								System.out.println("\nOj, ett fel uppstod: Det finns inte tillräckligt med pengar i automaten!\n");
							}
						} else if(temp.equals("c3")) {
							if(cocaCola.Buy(money) == true) {
								cocaCola.Use();
								money = money - cocaCola.productPrice;
							} else {
								System.out.println("\nOj, ett fel uppstod: Det finns inte tillräckligt med pengar i automaten!\n");
							}
						}
						flag = false;
					} else if(input.equals("r")) {
						flag = false;
					} else {
						System.out.println("Ogiltigt alternativ, återgår till menyn.");
						flag = false;
					}
				}
			}
			flag = true;
		} else if(input.equals("i")) { 
			while(flag) {
				//Skriver ut användarens plånbok
				printWallet(wallet);
				
				System.out.println("Vilka valörer vill du sätta in? \n1 för 1kr | 5 för 5kr | 10 för 10kr | 20 för 20kr | e för exit/avsluta");
				input = s.next().toLowerCase();
				
				//Bestämmer antalet valör som användaren vill insätta
				int num = 0;
				
				//loop meny till insättning av pengar
				if(input.equals("1")) {
					System.out.println("Hur många 1kr mynt vill du mata in i automaten?");
					num = s.nextInt();
					//uppdaterar plånbokens värde och pengarna som är insatta i maskinen.
					if(num <= wallet[0]) {
						wallet[0] = wallet[0] - num;
						flag = false;
						money = money + num;
					} else {
						System.out.println("Du har inte så många 1kr mynt");
					}
				} else if(input.equals("5")) {
					System.out.println("Hur många 5kr mynt vill du mata in i automaten?");
					num = s.nextInt();
					if(num <= wallet[1]) {
						wallet[1] = wallet[1] - num;
						flag = false;
						money = money + (5 * num);
					} else {
						System.out.println("Du har inte så många 5kr mynt!");
					}
				} else if(input.equals("10")) {
					System.out.println("Hur många 10kr mynt vill du mata in i automaten?");
					num = s.nextInt();
					if(num <= wallet[2]) {
						wallet[2] = wallet[2] - num;
						flag = false;
						money = money + (10 * num);
					} else {
						System.out.println("Du har inte så många 10kr mynt!");
					}
				} else if(input.equals("20")) {
					System.out.println("Hur många 20kr sedlar vill du mata in i automaten?");
					num = s.nextInt();
					if(num <= wallet[3]) {
						wallet[3] = wallet[3] - num;
						flag = false;
						money = money + (20 * num);
					} else {
						System.out.println("Du har inte så många sedlar!");
					}
				} else if (input.equals("e")) {
					flag = false;
				} else {
					System.out.println("Fel: Felaktig inmatning");
				}
			}
			flag = true;
		} else if(input.equals("w")) { 
			//temporär variabel för att hålla reda på antalet återbetalda valörer
			int bills = 0;
			if(money > 0) {
				
				 //Algoritm som kollar och avgör hur mycket pengar som ska ges tillbaka till användaren. 
				 //Pengarna hamnar direkt i användarens plånbok. 
				while(money != 0) {
					if((money / 20)>=1) {
						bills = (int) money / 20;
						money = money - (bills * 20);
						wallet[3] = wallet[3] + bills;
					} else if(money >= 10) {
						money = money - 10;
						wallet[2]++;
					} else if(money >= 5) {
						money = money - 5;
						wallet[1]++;
					} else {
						wallet[0] = wallet[0] + (int)money;
						money = 0;
					}
				}
				printWallet(wallet);
			} else {
				System.out.println("Det finns inga pengar i automaten.");
			}
		} else if(input.equals("e")) { 
			//Påminnelse till användaren om det fortfarande finns pengar kvar i automaten, när användaren vill avsluta programmet.
			if(money > 0) {
				System.out.println("\nÄr du säker du vill lämna (j/n)? Det finns " + money + "kronor kvar i automaten");
				input = s.next().toLowerCase();
				if(input.equals("j")) {
					System.out.println("Ha en fortsatt trevlig dag!");
					exit = true;
				}
			} else {
				System.out.println("Ha en fortsatt trevlig dag!");
				exit = true;
			}
			
		} else {
			System.out.println("Fel: '" + input + "' är inte ett giltigt menyalternativ, välj ett annat alternativ");
		}
	}
	//stänger scanner som öppnades upp i början av körningen.
	s.close();
}

//metod som validerar produktens namn, om den finns, returnerar true
private static boolean productValidate(String i) {
	return(i.equals("a1") || i.equals("a2") || i.equals("a3") 
			|| i.equals("b1") || i.equals("b2") || i.equals("b3") 
			|| i.equals("c1") || i.equals("c2") || i.equals("c3"));
		
}

//Metod som visar användarens plånbok och hur mycket pengar som finns inuti.
private static void printWallet(int[] wallet) {
	System.out.println("\nPlånboken innehåller: 1-krona: [" + wallet[0] + "st mynt] 5-krona: [" + wallet[1] + "st mynt] 10-krona: [" 
			+ wallet[2] + "st mynt] 20-kronorssedel: [" + wallet[3] + "st sedlar]");
	}
}
