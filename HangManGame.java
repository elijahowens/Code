import java.util.Scanner;
import java.util.Random;

public class HangManGame {

	public static void main(String[] args) {
		Scanner scanner  = new Scanner (System.in);
		Random random = new Random();
		boolean goodGuess;
		int badGuesses = 0;
		int dashCounter = 0;
		int halfWayMark;
		boolean reachedHalfWayPoint = false;
		boolean sure = false; 
		String [] guesses = {"the lion king", "cinderella","aladdin","beauty and the beast", "the little mermaid", "pinocchio"};
		// *********CODE SAMPLE 1***********
		// added extra slash because it is not a special character, called an "escape"
		String [] bodyParts = {" O", "\\", "\\ /", " |", "/", "/ \\"};	
		// initialize hangMan to blanks
		String [] hangMan = {" ", " ", " ", " ", " ", " ", " "};
		String [] hangManReset = {" ", " ", " ", " ", " ", " ", " "};
		
		
		// starts game
		boolean weArePlaying = true;
		// keeps looping until user stops (weArePlaying is set to false by entering "-" or saying "no" to "do you want to play another game?")
		while (weArePlaying)	{
			System.out.println("Let's play Hangman! The topic for this game is Disney movies.");
			reachedHalfWayPoint = false;
			// Creating a list (array) of the letters in the answer
			// "guesses.length" indicates how many items are in the list
			// "random.nextInt" Gives you a random number based on how many items are in the list
			//".toCharArray()" means convert sentence into a list of characters
			char [] randomWordToGuess = guesses[random.nextInt(guesses.length)].toCharArray(); 
			// formula for indicating halfWayMark
			halfWayMark = (int)randomWordToGuess.length/2;
			
			// "guesses[n] means return the nth item
			// we want to change this so that the amount of guesses equals the amount of bodyParts
			int amountOfGuesses = randomWordToGuess.length;
			// new amount of guesses based on bodyParts
			// create a new array that is just as long as the movie title selected
			char[] playerGuess = new char[amountOfGuesses];
			
			// initialize playerGuess to underscores since they haven't guessed yet
			for (int i = 0; i < playerGuess.length; i++)	{
				playerGuess[i] = '_';
				
			}
			// wordIsGuessed is false because they haven't guessed it yet and they just started
			boolean wordIsGuessed = false;
			
			// while word is not guessed and tries doesn't equal to the letters in the title, print amount of guesses left
			// change this to track number of bodyParts drawn
			while (!wordIsGuessed && badGuesses != bodyParts.length)	{
				System.out.println("Current guesses: ");
				// print user current correct guesses
				printArray(playerGuess);
				// print hangMan
				// %d uses calculation "amountOfGuesses - tries"
				// change amountofGuesses in calculation to bodyParts
				System.out.println();
				System.out.printf("You have %d tries left.\n", bodyParts.length - badGuesses);
				System.out.println();
				printStringArray(hangMan);
				System.out.println();
				System.out.println("Enter a single character.");
				// get the user's guess
				char input = scanner.nextLine().charAt(0);
				// increment number of tries by 1 (each time we go through the loop)
				// if the user enters a dash, exit the game
				
				if (input == '-')	{
					weArePlaying = false;
					wordIsGuessed = true;
				} else {
					// ******* CODE SAMPLE 3 *******
					// for anything else, check to see if user guessed the right letter
					// if they didn't guess the right letter, add another bodyPart
					goodGuess = false;
					dashCounter = 0;
					for (int i = 0; i < randomWordToGuess.length; i++)	{
						// if letter matches, store user's input into answer
						if (randomWordToGuess[i] == input)	{
							playerGuess[i] = input;
							goodGuess = true;
							
							
						} // keep counting dashes waiting to get down to halfWayPoint
						if (playerGuess[i] == '_') 	{
							dashCounter++;
					}
					
						
					}  
					
					// if dashCounter is less than or equal to halfWayMark, print message. Don't keep printing after halfWayPoint (set to true).
					// ***** CODE SAMPLE 4 *****
					if ((dashCounter <= halfWayMark) &&  (!reachedHalfWayPoint))	{
						System.out.println("You are half way there! Keep it up!");
					    reachedHalfWayPoint = true;
					}
					
					
					// ******** CODE SAMPLE 5 *********
					// if not a good guess, bad guesses increment
					if (!goodGuess)		{
						hangMan [badGuesses] = bodyParts[badGuesses];
						badGuesses++;
					}
				// if user is correct, set the wordIsGuessed to true and print "You win!"
					if (isTheWordGuessed(playerGuess))	{
						wordIsGuessed = true;
						System.out.println("You win!");
						
						// add "if" statement to determine if we ran out of bodyParts
						
						
					}
			
			}
			} // go back to 2nd while loop
			System.out.println("Game over.");
			// if word is not guessed, print the current hangMan body parts 
			if (!wordIsGuessed)	{
			printStringArray(hangMan);	}
			// if the word is not guessed, print "You ran out of guesses."
			if (!wordIsGuessed) System.out.println("You ran out of guesses.");
			System.out.println();
			// until user exactly says "yes" or "no", we are !sure (not sure)
			// in which case a loop will ask again
			sure = false;
			while (!sure)	{
			System.out.println("Do you want to play another game? (yes/no)");
			String anotherGame = scanner.nextLine();
			// entering "no" breaks loop and makes "weArePlaying" false
			if (anotherGame.equals("no")) {
			weArePlaying = false;
			sure = true;
			System.out.println("Goodbye.");	}
			// we set weArPlaying to "true" because off switch sets it to false, badGuesses is reinitialized back to 0, hangManReset erases body parts
			// entering "yes" continues  weArePlaying loop and ends !sure (not Sure) loop 
			else if  (anotherGame.equals("yes"))	{
				weArePlaying = true;
				badGuesses = 0;
				hangMan = hangManReset;
				sure = true;
				}
			// Any answer other than "yes" or "no" will ask this:
			else	{ 
			System.out.println("Didn't get that. What did you mean?");	
			
			System.out.println();
			}
			
		}
		
		}
		
		
	}
	


	
	// printArray is a new method that prints whatever they guess
	// takes as an input that the array of characters that the user has guessed so far
		public static void printArray (char[] array) {
			System.out.println();
			for (int i = 0; i < array.length; i++)	{
				System.out.print(array[i] + " ");
				
			}	// prints skip line
				System.out.println();
	}
		// Determining if they guess the word correctly
		public static boolean isTheWordGuessed(char[]  array)	{
			
			// if there are any dashes left they have not guessed it yet, return false 
			for (int i = 0; i < array.length; i++)	{
				if (array[i]  == '_') return false;
			} // if there aren't any dashes left, return true (guessed the word correctly)
			return true;
		}
	
		// This method is used to print the hangMan
		// ********** CODE SAMPLE 2 **********
		public static void printStringArray (String [] array) {
			for (int i = 0; i < array.length; i++)	{
				// if tries do not equal 6, print a body part
				// when (i != 5) it does not print the two legs 
				if (i != 6)	{
					// if the body part after is not two arms and not two legs, then it is OK to print the body part
						if ((!array[i + 1].equals("\\ /")) && (!array[i + 1].equals("/ \\")  ))	{
							
				// print a body part
				System.out.println (array[i]);	
				}
						
						
						
							}
			
			
					
				}
			
			
			System.out.println();
			}
				
	}


