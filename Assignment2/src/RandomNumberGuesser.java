import java.util.Scanner;

/**
 * Class: CMSC203
 * Instructor: Grinberg
 * Description: Runs a guessing game where the user is tasked with giving a number
 * and is told whether the number is above or below the answer.
 * Due: 9/27/2020
 * I pledge that I have completed the programming assignment independently.
    I have not copied the code from a student or any source.
    I have not given my code to any student.
    Print your Name here: Justin Tritinger
 * @author Justin Tritinger
 */
public class RandomNumberGuesser {

    /** Performs operations required to return an int input from user.
     * @return an integer, scanned input
     */
    private static int getGuess() {
        int guess = RNG.scan.nextInt();
        RNG.scan.nextLine();
        return guess;
    }

    public static void main(String[] args) {
        boolean shouldContinue = true;
        RNG.scan = new Scanner(System.in);

        do {
            int number = RNG.rand();
            int min = 0, max = 100;
            RNG.resetCount();

            System.out.print("Enter your first guess: ");

            int guess = getGuess();

            // Run guesser
            while (guess != number) {
                while (!RNG.inputValidation(guess, min, max)) {
                    guess = getGuess();
                }

                if (guess > number) {
                    System.out.println("Your guess was too high.");
                    max = guess;
                } else if (guess < number) {
                    System.out.println("Your guess was too low.");
                    min = guess;
                }

                System.out.println("Number of guesses is " + RNG.getCount());

                System.out.print("Enter your next guess between " + min + " and " + max + ": ");

                guess = getGuess();
            }

            System.out.println("Congratulations, you guessed correctly!");
            System.out.println("Try again? (yes/no)");
            String input;

            // Ask to play again
            do {
                input = RNG.scan.nextLine();
                if (input.equals("no")) shouldContinue = false;
            } while (!(input.equals("yes") || input.equals("no")));

        } while (shouldContinue);

        System.out.println("Thanks for playing...");

        // Print Class/Programmer Footer
        System.out.println("Programmer: Justin Tritinger - CMSC203");
    }

    private void runGuesser(int firstGuess, int answer) {

    }

}
