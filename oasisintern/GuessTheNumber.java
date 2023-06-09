import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber 
    {
    public static void main(String[] args)
      {
        Scanner sc=new Scanner(System.in);
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;

        boolean playAgain = true;
        while (playAgain)
           {
            int targetNumber = generateRandomNumber(minRange, maxRange);
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts && !guessedCorrectly) {
                int guess = getUserGuess(minRange, maxRange);

                if (guess == targetNumber)
                   {
                    System.out.println("Congratulations! You guessed the number!");
                    score += maxAttempts - attempts;
                    guessedCorrectly = true;
                    System.out.println("Score="+score*12+"/120");
                    score=0;
                    attempts=0;
                    System.out.println("press 1 to play again or 2 to exit the game");
                    int choice = sc.nextInt();
                     if(choice==2)
                     {
                      System.exit(0);
                     }
               
                    } 
                    else if (guess < targetNumber) 
                    {
                    	System.out.println("low! Try again.");
                    } 
                    else
                    {
                    System.out.println("high! Try again.");
                    }

                attempts++;
            }

            if (!guessedCorrectly) {
                System.out.println( "Sorry, you ran out of attempts. The number was: " + targetNumber);
            }
        }

        
    }

    private static int generateRandomNumber(int minRange, int maxRange) {
        Random random = new Random();
        return random.nextInt(maxRange - minRange + 1) + minRange;
    }

    private static int getUserGuess(int minRange, int maxRange) 
   {
        Scanner sc=new Scanner(System.in);
        int guess = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("hey user!");
                System.out.println("Guess a number between " + minRange + " and " + maxRange + ":");
                int input=sc.nextInt(); 
                guess = input;
                if (guess < minRange || guess > maxRange) {
                    throw new NumberFormatException();
                }
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between " + minRange + " and " + maxRange + ".");
            }
        }

        return guess;
    }
}
