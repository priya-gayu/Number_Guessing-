import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class AdvancedNumberGuessingGame {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("🎯 WELCOME TO THE NUMBER GUESSING GAME 🎯");

        boolean playAgain;
        do {
            playGame();
            playAgain = askReplay();
        } while (playAgain);

        System.out.println("Thanks for playing! 👋");
        sc.close();
    }

    static void playGame() {
        int maxNumber = chooseDifficulty();
        int secretNumber = random.nextInt(maxNumber) + 1;
        int attempts = calculateAttempts(maxNumber);

        System.out.println("\nI have chosen a number between 1 and " + maxNumber);
        System.out.println("You have " + attempts + " attempts. Good luck! 🍀");

        for (int i = 1; i <= attempts; i++) {
            int guess = getValidInput(i);

            if (guess == secretNumber) {
                System.out.println("🎉 Correct! You guessed it in " + i + " attempts.");
                return;
            } else if (guess < secretNumber) {
                System.out.println("🔼 Too low!");
            } else {
                System.out.println("🔽 Too high!");
            }
        }

        System.out.println("❌ Game Over! The correct number was: " + secretNumber);
    }

    static int chooseDifficulty() {
        System.out.println("\nChoose Difficulty:");
        System.out.println("1. Easy (1–50)");
        System.out.println("2. Medium (1–100)");
        System.out.println("3. Hard (1–500)");

        int choice;
        while (true) {
            try {
                System.out.print("Enter choice (1-3): ");
                choice = sc.nextInt();
                if (choice >= 1 && choice <= 3) break;
            } catch (InputMismatchException e) {
                sc.next(); // clear buffer
            }
            System.out.println("Invalid choice. Try again.");
        }

        return switch (choice) {
            case 1 -> 50;
            case 2 -> 100;
            default -> 500;
        };
    }

    static int calculateAttempts(int maxNumber) {
        return (int) (Math.log(maxNumber) / Math.log(2)) + 1;
    }

    static int getValidInput(int attempt) {
        while (true) {
            try {
                System.out.print("Attempt " + attempt + " - Enter your guess: ");
                return sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next(); // clear invalid input
                System.out.println("❗ Please enter a valid number.");
            }
        }
    }

    static boolean askReplay() {
        System.out.print("\nDo you want to play again? (yes/no): ");
        String response = sc.next().toLowerCase();
        return response.equals("yes") || response.equals("y");
    }
}
