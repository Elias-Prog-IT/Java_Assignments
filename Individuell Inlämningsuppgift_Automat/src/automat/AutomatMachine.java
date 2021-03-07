/**
 * 
 * @author Elias Posluk 
 * Student-id:(tuc.elias.posluk)
 * @date 07/03/2021
 * Individuell uppgift
 * AutomatMachine.java
 * Kurs: Programmering f�r testare 
 * TUC Yrkesh�gskola - Mjukvarutestare
 * 
 */

package automat;

import java.util.Scanner;

public class AutomatMachine 
{

	public static void main(String[] args) 
	{
	//scanner f�r anv�ndarinput till automaten
	Scanner s = new Scanner(System.in);
	
	//F�r att spara anv�ndarinput
	String input;
	
	//Avslutar loopen p� menyn och programmet
	boolean exit = false;
	
	//flagga som anv�nds i den n�stlade loopen
	boolean flag = true;
	
	// wallet (pl�nboken) inneh�ller den summa pengar anv�ndaren har
	// I stigande ordning s� �r index 0 f�r 1 krona, index 2 �r f�r 5 kr, osv..
	int[] wallet = {10, 10, 10, 10};
			
	//M�ngden pengar som �r i automaten, den startar fr�n v�rdet noll.
	double money = 0;
	
	//Initialiserar produkternas objekt.
	Clothing shirt = new Clothing("T-shirt", "Vit T-shirt.", 50.0,  "En bekv�m T-shirt, som du tar p� dig.");
	Clothing pants = new Clothing("Byxor", "Diesel jeans.", 105.0,  "Nya och snygga jeans.");
	Clothing hat = new Clothing("M�ssa", "Brun M�ssa.", 25.0,  "M�ssan framh�ver dina �gon och v�rmer dina �ron.");
	Food kexchoklad = new Food("Kexchoklad", "Kexchoklad med tre lager frasiga choklad�verdragna r�n.", 10.0,  "MMMMM..Frasig!");
	Food potatoChips = new Food("Chips", "Saltade potatischips.", 18.0,  "MUMS! Bra snacks som g�r bra med en l�skande dryck!");
	Food granolaBar = new Food("GranolaBar", "Granolabar med choklad�verdrag.", 15.0,  "MUMS! F� extra energi under dagen!");
	Drink water = new Drink("Raml�sa", "Raml�sa med mango smak.", 20.0,  "Slurp! Uppfriskande!");
	Drink sprite = new Drink("Sprite", "Sprite med ton av citron.", 28.0,  "Slurp! Smaskens!");
	Drink cocaCola = new Drink("Coca-Cola", "Coca-Cola Zero, utan socker.", 30.0,  "Slurp! Kan du k�nna skillnaden?");
	
	
	/*  Menyval i while-loopen:
	 *   s - (select) f�r att se beskrivningen p� produkten och valet att k�pa produkten
	 *   i - (insert) ins�ttning av pengar till maskinen.
	 *   w - (withdraw) Uttag av antingen hela beloppet eller kvarvarande summan efter k�p
	 *   e - (exit) Avslutar programmet och k�rningen.
	 */
	while(!exit) {
		//Skriver ut menyn 
		System.out.println("\n* * * * * * * * * * * * * * * Allt M�jligt Automaten! * * * * * * * * * * * * * ");
		System.out.println("*                                                                             *");
		System.out.printf("* %19s] A1%19s] A2%19s] A3       *\n", "[" + shirt + " " + shirt.productPrice + "kr",  "[" + pants+ " " +pants.productPrice + "kr", "[" + hat  + " " + hat.productPrice + "kr");
		System.out.printf("* %19s] B1%19s] B2%19s] B3       *\n", "[" + kexchoklad + " " + kexchoklad.productPrice + "kr", "[" + potatoChips + " " + potatoChips.productPrice + "kr", "[" + granolaBar + " " + granolaBar.productPrice + "kr");
		System.out.printf("* %19s] C1%19s] C2%19s] C3       *\n", "[" + water + " " + water.productPrice + "kr", "[" + sprite + " " + sprite.productPrice + "kr", "[" + cocaCola + " " +  cocaCola.productPrice + "kr");
		System.out.println("*                                                                             *");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println("Insatta pengar i automaten:" + " " +  money + "kr");
		printWallet(wallet);
		System.out.println("\nMeny: 's' V�lj en produkt | 'i' pengar ins�ttning | 'w' pengar uttag/retur | 'e' f�r att avsluta/exit");
		System.out.print("Urval: ");
	
	
		//H�mtar anv�ndarinmatning
		input = s.next().toLowerCase();
		
		//Kontrollerar anv�ndarinmatningen 
		if(input.equals("s")) { 
			
			while(flag) {
				System.out.print("\nAnge koden f�r den produkt du vill ha: ");
				input = s.next().toLowerCase();
				//tempvariabeln sparar v�rdet p� den valda produkten, om anv�ndaren k�per produkten.
				String temp = input;
				//validerar produktnamnet
				if(!productValidate(input)) {
					System.out.println("Ange en giltig produktkod");
				} else {
					//skriver ut beskrivningen p� produkterna.
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
					
					//Anv�ndaren f�r m�jligheten att k�pa produkten, n�r anv�ndaren befinner sig i beskrivningsdelen till produkten.
					System.out.println("Skulle du vilja...\n(k) - K�pa produkten \n(r) - returnera till menyn");
					input = s.next().toLowerCase();
					//om anv�ndaren v�lkher alternativet "k" s� kontrolleras om man kan k�pa produkten.
					if(input.equals("k")) {
						if(temp.equals("a1")) {
							//om automaten har tillr�ckligt med pengar f�r att k�pa produkten.
							if(shirt.Buy(money) == true) {
								//Uppdaterar pengarna som �r kvar i automaten och tipsar om hur man kan anv�nda produkten.
								shirt.Use();
								money = money - shirt.productPrice;
							} else {
								//Om automaten inte har tillr�ckligt med pengar, s� skriver automaten ut en felmeddelande.
								System.out.println("\nOj, ett fel uppstod: Det finns inte tillr�ckligt med pengar i automaten!\n");
							}
						} else if(temp.equals("a2")) {
							if(pants.Buy(money) == true) {
								pants.Use();
								money = money - pants.productPrice;
							} else {
								System.out.println("\nOj, ett fel uppstod: Det finns inte tillr�ckligt med pengar i automaten!\n");
							}
						} else if(temp.equals("a3")) {
							if(hat.Buy(money) == true) {
								hat.Use();
								money = money - hat.productPrice;
							} else {
								System.out.println("\nOj, ett fel uppstod: Det finns inte tillr�ckligt med pengar i automaten!\n");
							}
						} else if(temp.equals("b1")) {
							if(kexchoklad.Buy(money) == true) {
								kexchoklad.Use();
								money = money - kexchoklad.productPrice;
							} else {
								System.out.println("\nOj, ett fel uppstod: Det finns inte tillr�ckligt med pengar i automaten!\n");
							}
						} else if(temp.equals("b2")) {
							if(potatoChips.Buy(money) == true) {
								potatoChips.Use();
								money = money - potatoChips.productPrice;
							} else {
								System.out.println("\nOj, ett fel uppstod: Det finns inte tillr�ckligt med pengar i automaten!\n");
							}
						} else if(temp.equals("b3")) {
							if(granolaBar.Buy(money) == true) {
								granolaBar.Use();
								money = money - granolaBar.productPrice;
							} else {
								System.out.println("\nOj, ett fel uppstod: Det finns inte tillr�ckligt med pengar i automaten!\n");
							}
						} else if(temp.equals("c1")) {
							if(water.Buy(money) == true) {
								water.Use();
								money = money - water.productPrice;
							} else {
								System.out.println("\nOj, ett fel uppstod: Det finns inte tillr�ckligt med pengar i automaten!\n");
							}
						} else if(temp.equals("c2")) {
							if(sprite.Buy(money) == true) {
								sprite.Use();
								money = money - sprite.productPrice;
							} else {
								System.out.println("\nOj, ett fel uppstod: Det finns inte tillr�ckligt med pengar i automaten!\n");
							}
						} else if(temp.equals("c3")) {
							if(cocaCola.Buy(money) == true) {
								cocaCola.Use();
								money = money - cocaCola.productPrice;
							} else {
								System.out.println("\nOj, ett fel uppstod: Det finns inte tillr�ckligt med pengar i automaten!\n");
							}
						}
						flag = false;
					} else if(input.equals("r")) {
						flag = false;
					} else {
						System.out.println("Ogiltigt alternativ, �terg�r till menyn.");
						flag = false;
					}
				}
			}
			flag = true;
		} else if(input.equals("i")) { 
			while(flag) {
				//Skriver ut anv�ndarens pl�nbok
				printWallet(wallet);
				
				System.out.println("Vilka val�rer vill du s�tta in? \n1 f�r 1kr | 5 f�r 5kr | 10 f�r 10kr | 20 f�r 20kr | e f�r exit/avsluta");
				input = s.next().toLowerCase();
				
				//Best�mmer antalet val�r som anv�ndaren vill ins�tta
				int num = 0;
				
				//loop meny till ins�ttning av pengar
				if(input.equals("1")) {
					System.out.println("Hur m�nga 1kr mynt vill du mata in i automaten?");
					num = s.nextInt();
					//uppdaterar pl�nbokens v�rde och pengarna som �r insatta i maskinen.
					if(num <= wallet[0]) {
						wallet[0] = wallet[0] - num;
						flag = false;
						money = money + num;
					} else {
						System.out.println("Du har inte s� m�nga 1kr mynt");
					}
				} else if(input.equals("5")) {
					System.out.println("Hur m�nga 5kr mynt vill du mata in i automaten?");
					num = s.nextInt();
					if(num <= wallet[1]) {
						wallet[1] = wallet[1] - num;
						flag = false;
						money = money + (5 * num);
					} else {
						System.out.println("Du har inte s� m�nga 5kr mynt!");
					}
				} else if(input.equals("10")) {
					System.out.println("Hur m�nga 10kr mynt vill du mata in i automaten?");
					num = s.nextInt();
					if(num <= wallet[2]) {
						wallet[2] = wallet[2] - num;
						flag = false;
						money = money + (10 * num);
					} else {
						System.out.println("Du har inte s� m�nga 10kr mynt!");
					}
				} else if(input.equals("20")) {
					System.out.println("Hur m�nga 20kr sedlar vill du mata in i automaten?");
					num = s.nextInt();
					if(num <= wallet[3]) {
						wallet[3] = wallet[3] - num;
						flag = false;
						money = money + (20 * num);
					} else {
						System.out.println("Du har inte s� m�nga sedlar!");
					}
				} else if (input.equals("e")) {
					flag = false;
				} else {
					System.out.println("Fel: Felaktig inmatning");
				}
			}
			flag = true;
		} else if(input.equals("w")) { 
			//tempor�r variabel f�r att h�lla reda p� antalet �terbetalda val�rer
			int bills = 0;
			if(money > 0) {
				
				 //Algoritm som kollar och avg�r hur mycket pengar som ska ges tillbaka till anv�ndaren. 
				 //Pengarna hamnar direkt i anv�ndarens pl�nbok. 
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
			//P�minnelse till anv�ndaren om det fortfarande finns pengar kvar i automaten, n�r anv�ndaren vill avsluta programmet.
			if(money > 0) {
				System.out.println("\n�r du s�ker du vill l�mna (j/n)? Det finns " + money + "kronor kvar i automaten");
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
			System.out.println("Fel: '" + input + "' �r inte ett giltigt menyalternativ, v�lj ett annat alternativ");
		}
	}
	//st�nger scanner som �ppnades upp i b�rjan av k�rningen.
	s.close();
}

//metod som validerar produktens namn, om den finns, returnerar true
private static boolean productValidate(String i) {
	return(i.equals("a1") || i.equals("a2") || i.equals("a3") 
			|| i.equals("b1") || i.equals("b2") || i.equals("b3") 
			|| i.equals("c1") || i.equals("c2") || i.equals("c3"));
		
}

//Metod som visar anv�ndarens pl�nbok och hur mycket pengar som finns inuti.
private static void printWallet(int[] wallet) {
	System.out.println("\nPl�nboken inneh�ller: 1-krona: [" + wallet[0] + "st mynt] 5-krona: [" + wallet[1] + "st mynt] 10-krona: [" 
			+ wallet[2] + "st mynt] 20-kronorssedel: [" + wallet[3] + "st sedlar]");
	}
}
