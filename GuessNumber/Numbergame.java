import java.util.Random;
import java.util.Scanner;

public class Numbergame {
	
	public static void main(String[] args) { //number setup.
		//New a Scanner to get the input of User
		Scanner scanner = new Scanner(System.in);
		//New a Random to generate random number
		Random Rnumber = new Random();

		int games = 0; //the total games time.
		int bestGuess = 100; //the try times from the best one.
		int totalGuesses = 0; //the total guess times.
		int testGuess = 0; 
		String choice = " "; 
		Boolean gameOver = false; //set up the first time is 'false', which means player want to play the game.
		//these three both for decide y/n choice. when choice is “n”, means gameOver, quit the game.
		gameIntro();
			
		while (gameOver == false) { //setup return for the game, ask player whether they want to play again.
			//set up the when player want to play the game, what will happened.
			testGuess = playGame(scanner, totalGuesses, Rnumber);
			totalGuesses += testGuess;

			if (testGuess < bestGuess) {
				bestGuess = testGuess;
			}
			
			games++;
			
			System.out.print("Do you want to play again? ");
			choice = scanner.next();
			
			if (choice.toLowerCase().equals("n")) { //set up what happened if player tab "n", which means player want to quit.
				gameOver = true; //Because "y" is false case, so "n" is true.
			}
		}
		
		gameResult(bestGuess, games, totalGuesses);
	}
	
	public static void gameIntro() { //introduction of the game.
		System.out.println("This program will allow you to play a guessing game.");
		System.out.println("I will think of a number between 1 and");
		System.out.println("100 and will allow you to guess until");
		System.out.println("you get it. For each guess, I will tell you");
		System.out.println("whether the answer is higher or lower");
		System.out.println("than your guess.");
	}
	
	public static int playGame(Scanner scanner, int totalGuesses, Random Rnumber) { 
		//body of the game. Determine the size relationship between random numbers and guessing numbers.
		System.out.println( );
		System.out.println("I'm thinking of a number between 1 and 100...");
		
		int number = Rnumber.nextInt(100) + 1; //set up random number.
		Boolean gameOver = false; //set up the first time is 'false', which means player want to play the game.
		int tries = 0; //when the beginning, the try time is 0.
		
		while (gameOver == false) { //the loop of the main game: determine the relationship between two numbers.
			System.out.print("Your guess? ");
			int guess = scanner.nextInt();
			tries++;
			//Add the guess time to totalGuesses
			totalGuesses += tries;
			if (guess == number) {
				System.out.println("You got it right in " + tries + " guesses");
				gameOver = true; //Game over. 
			} else if (guess < number) {//If too low
				System.out.println("It's lower.");
			} else {//If too high
				System.out.println("It's higher.");
			}
		}
		return tries; //return to player’s try times, get the number of the times.
	}

	//When we quit the game, the game's specific stats are displayed
	public static void gameResult(int bestGuess, int games, int totalGuesses) { //result of the game.
		System.out.println("Overall results:");
		System.out.println("	total games   = " + games);
		System.out.println("	total guesses = " + totalGuesses);
		System.out.println("	guesses/game  = " + ((double)totalGuesses/games)); //using double to get decimal places.
		System.out.println("	best game     = " + bestGuess);
	}
}