import java.util.Random;
import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 7;
        int rounds = 0;
        int score = 0;
        String playAgain;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            rounds++;
            int number = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + rounds + ": Guess the number between " + lowerBound + " and " + upperBound + ".");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < number) {
                    System.out.println("Too low! Try again.");
                } else if (guess > number) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                    score = score + maxAttempts - attempts + 1;
                    guessedCorrectly = true;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + number + ".");
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\nGame Over! You played " + rounds + " rounds and your final score is " + score + ".");
        scanner.close();
    }
}
