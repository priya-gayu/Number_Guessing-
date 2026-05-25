import java.util.Scanner;

public class NUMBER_GUESSING {
    
    public static void guessingNumberGame()
    {
        Scanner sc = new Scanner(System.in);


        int number = 1 + (int)(100 * Math.random());
        
        
        int K = 5;

        System.out.println(
            "A number is chosen between 1 and 100.");
        System.out.println(
            "You have " + K
            + " attempts to guess the correct number.");

        
        for (int i = 0; i < K; i++) {
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();

            
            if (guess == number) {
                System.out.println(
                    " Congratulations! You guessed the correct number.");
                sc.close();
                
               
                return;
            }
            else if (guess < number) {
                System.out.println(
                    " The number is greater than " + guess);
            }
            else {
                System.out.println(
                    " The number is less than " + guess);
            }
        }

        
        System.out.println(
            "You've exhausted all attempts. The correct number was: "
            + number);
        sc.close();
    }

    public static void main(String[] args)
    {
        guessingNumberGame();
    }
}