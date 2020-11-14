/**
 * 
 * @author Elias Posluk 
 * Student-id: b15elipo
 * @date  2015-10-07
 * MiniProject
 * Deck.Java
 * Högskolan i Skövde (University of Skövde)
 * 
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Deck 
{
	private ArrayList<Card> cards; //Arraylist of cards
	 Scanner input = new Scanner(System.in); 
	
	public Deck()// Constructor Deck
	{
		this.cards = new ArrayList<Card>();
		generateCardDeck();	
		cardShuffle();
	} 
	
	public void generateCardDeck()//Makes a card Deck
	{
		for(Suit cardSuit : Suit.values())//For every Suit in enum
		{									//iterate 
			for (Value cardValue : Value.values()) //Value is refering to the enum, and .value is refering actual values in the enum 
			{
				this.cards.add(new Card(cardSuit,cardValue)); // adds a new card
			} 
		}
	}
	
	public void cardShuffle()
	{
		ArrayList<Card>tempDeck = new ArrayList<Card>();
		Random random = new Random(); //Random
		
		int randomCardIndex = 0;
		int OriginalSize = this.cards.size();
		
		for (int i = 0; i < OriginalSize; i++) 
		{
			randomCardIndex = random.nextInt((this.cards.size()-1)+1);
			tempDeck.add(this.cards.get(randomCardIndex));
			//Remove from original deck
			this.cards.remove(randomCardIndex);
			
		}
		this.cards = tempDeck; // put it back into the original deck
	}
	
	public Card drawCard()
	{
		return cards.get(cards.size()-1);
	}
	
	
	public String toString() // returns a string with all the cards
	{
		int i=1;
		String cardListOutPut = " ";
		
		for (Card aCard : this.cards) 
		{
			cardListOutPut +=  "\n" + i + "-" + aCard.toString();
			i++;
		}
		return cardListOutPut;
	}
	
}