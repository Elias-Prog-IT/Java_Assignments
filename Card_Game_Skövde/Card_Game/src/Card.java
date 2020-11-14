/**
 * 
 * @author Elias Posluk 
 * Student-id: b15elipo
 * @date  2015-10-07
 * MiniProject
 * Card.Java
 * Högskolan i Skövde (University of Skövde)
 * 
 */

public class Card 
{
	//Variables
	private Value value; 
	private Suit suit;
	
	private int intValue;
	private int intSuit;
	private int intScore;
	
	public Card(Suit suit, Value value) // constructor card
	{
		this.value = value;
		this.suit = suit;
		setValue();
		setSuit();
		
		intScore = intSuit + intValue;
	}
	public int getScore()
	{
		return intScore;
	}
	private Value getValue()
	{
		return this.value;
	}
	private void setValue() // Setting the values for the cards
	{
		switch(value)
		{
		case ACE : intValue = 1;
		break;
		case TWO : intValue = 2;
		break;
		case THREE : intValue = 3;
		break;
		case FOUR : intValue = 4;
		break;
		case FIVE : intValue = 5;
		break;
		case SIX : intValue = 6;
		break;
		case SEVEN : intValue = 7;
		break;
		case EIGHT : intValue = 8;
		break;
		case NINE : intValue = 9;
		break;
		case TEN : intValue = 10;
		break;
		case JACK : intValue = 11;
		break;
		case QUEEN : intValue = 12;
		break;
		case KING : intValue = 13;
		break;
		}
	}
	
	private void setSuit() // Setting the values for the suit of cards which will be the bonus points
	{
		switch(suit)
		{
		case CLUB : intSuit = 6;
		break;
		case DIAMOND : intSuit = 4;
		break;
		case HEART : intSuit = 8;
		break;
		case SPADE : intSuit = 10;
		break;
		}
		
	}
	
	public String toString()//Printing out the suit and value
	{
		return this.suit.toString() + "-" + this.value.toString();
	}
}

