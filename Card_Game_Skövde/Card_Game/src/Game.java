/**
 * 
 * @author Elias Posluk 
 * Student-id: b15elipo
 * @date  2015-10-07
 * MiniProject
 * Game.Java
 * Högskolan i Skövde (University of Skövde)
 * 
 */
import java.io.IOException;
import java.util.Scanner;


public class Game {
	
	public static void main(String[] args) throws IOException 
	{
		System.out.println("Welcome to the game lucky one! ");// Welcome message
		Scanner input = new Scanner(System.in);
		// Creating the playing deck.
		Deck playingDeck = new Deck();
		//variables
		int playerScore = 0, computerScore = 0;
		int replay;
	Outer:while (true) //Keeps the game running, until you press 1 to terminate the program
			{
				playingDeck.cardShuffle();
				Card tempCard1 = playingDeck.drawCard();
				System.out.println("Computer draws " + tempCard1.toString());
				System.out.println("Computer score " + tempCard1.getScore());
				playingDeck.cardShuffle();
				Card tempCard2 = playingDeck.drawCard();
				System.out.println("Player draws " + tempCard2.toString());
				System.out.println("Player score " + tempCard2.getScore());
				
			
				if (tempCard1.getScore() > tempCard2.getScore()) {
					System.out.println("Computer got the higest score");
					System.out.println("Computer Scores: " + tempCard1.getScore()+"\n");
					computerScore++;
				} else if (tempCard2.getScore() > tempCard1.getScore()) {
					System.out.println("Player got the higest score");
					System.out.println("Player Scores: " + tempCard2.getScore());
					playerScore++;
				}
				System.out.println("Victories " + " Human:  " + playerScore + " " + "Computer: " + computerScore);
				
//				System.out.println("Do you want to play again? (y/n)");
//				String yes = input.nextLine();
				
				do { // check the user's input
	                System.out.println("Type 0 to play again. Type 1 to quit.");
	                replay = input.nextInt();
	                if (replay == 1)
	                {
	                	System.out.println("Game Over!");
	                	break Outer;
	                	//exit(1);
	                }
	                if (replay != 0 && replay != 1) {
	                    System.out.println("Input not recognized.");
	                }
	               
	            } while (replay != 0 && replay != 1);
				//break;
	        } 
		//while (replay == 0); // end of do-while loop
			}// While

	}
