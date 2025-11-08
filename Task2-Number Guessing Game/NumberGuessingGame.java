import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain = true;

        System.out.println("🎯 Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100...");
        System.out.println("Try to guess it!\n");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (1-100): ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts!");
                    score += (11 - attempts); // fewer attempts = higher score
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You ran out of attempts! The number was: " + numberToGuess);
            }

            System.out.println("Your total score: " + score);
            System.out.print("\nDo you want to play again? (y/n): ");
            String choice = sc.next().toLowerCase();

            if (!choice.equals("y")) {
                playAgain = false;
                System.out.println("\nThanks for playing! 👋");
            }
        }
        sc.close();
    }
}
