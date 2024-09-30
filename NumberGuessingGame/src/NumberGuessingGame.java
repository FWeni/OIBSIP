import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static int attempts;
    private static int round;
    private static int score;
    private static int generatedNumber;
    private  static boolean noMoreGuesses = false;


    public static void main(String[] args) {
        System.out.println("Welcome to the number guessing game.");
        System.out.println("Aim of the game is for you to guess the randomly generated " +
                "number, ranging from 1 to 100 in 3 attempts");
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("[P]lay");
            String begin = scanner.next();
            if(begin.equalsIgnoreCase("p")) {
                play();
            }
            while (noMoreGuesses) {
                System.out.println("[T]ry again or [Q]uit?");
                String decision = scanner.next();
                if (decision.equalsIgnoreCase("t")) {
                    play();
                }
                if(decision.equalsIgnoreCase("q")) {
                    System.out.println("See you next time!");
                    break;
                }
            }

        } catch (Exception e) {
            System.err.println("Invalid guess input!");
        }
    }
    private static void play() {
        attempts = 1;
        round = 1;
        score = 0;
        startGame();
    }
    private static int numberGenerator() {
        Random random = new Random();
        int min = 1, max = 100;
        return random.nextInt(min,max);
    }
    private static void startGame() {
        Random random = new Random();
        ArrayList<String> celebrationText = new ArrayList<>();
        celebrationText.add("Brilliant, amazing stuff!");
        celebrationText.add("Wow, you did it.");
        celebrationText.add("Well done, keep it up!");
        celebrationText.add("Congratulations, you doing great.");

        generatedNumber = numberGenerator();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your guess below :");


        while (attempts <= 3) {
            System.out.println(generatedNumber);
            int guess = scanner.nextInt();
            if (attempts == 1 && guess == generatedNumber) {
                System.out.println(celebrationText.get((random.nextInt(0, celebrationText.size()))));
                score += 3;
                round++;
                if (score > 0) {
                    System.out.println("Welcome to round : " + round);
                    System.out.println("Current score : " + score);
                    startGame();
                }
            } else if (attempts == 2 && guess == generatedNumber) {
                System.out.println(celebrationText.get((random.nextInt(0, celebrationText.size()))));
                score += 2;
                round++;
                if (score > 0) {
                    System.out.println("Welcome to round : " + round);
                    System.out.println("Current score : " + score);
                    startGame();
                }
            } else if(attempts == 3 && guess == generatedNumber) {
                System.out.println(celebrationText.get((random.nextInt(0, celebrationText.size()))));
                score += 1;
                round++;
                if (score > 0) {
                    System.out.println("Welcome to round : " + round);
                    System.out.println("Current score : " + score);
                    startGame();
                }
            } else if (attempts < 3 && guess > generatedNumber) {
                System.out.println("Your guess is too high.");
                System.out.println("Try again :");
            } else if(attempts < 3 && guess < generatedNumber) {
                System.out.println("Your guess is too low.");
                System.out.println("Try again :");
            } else if(guess != generatedNumber) {
                noMoreGuesses = true;
                System.out.println("Sorry, but you have ran out of attempts");
                System.out.println("The generated number was : "+generatedNumber);

            }
            attempts++;

        }
    }
}