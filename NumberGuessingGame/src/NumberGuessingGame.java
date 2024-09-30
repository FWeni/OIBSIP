import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static int attempts;
    private static int round;
    private static int score;
    private static int generatedNumber;


    public static void main(String[] args) {
        play();
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("[T]ry again or [Q]uit?");
            String decision = scanner.next();
            while (decision.equalsIgnoreCase("t")) {
                play();
                if(decision.equalsIgnoreCase("q")) {
                    System.out.println("See you next time!");
                    break;
                }
                decision = "";
            }
        } catch (Exception e) {
            System.err.println("Invalid guess input!");
        }
    }
    private static void play() {
        attempts = 1;
        round = 1;
        score = 0;
        System.out.println("Welcome to the number guessing game.");
        System.out.println("Aim of the game is for you, to guess the randomly generated number in 3 attempts");
        startGame();
    }
    private static void numberGenerator() {
        Random random = new Random();
        int min = 1, max = 100;
        generatedNumber = random.nextInt(min,max);
    }
    private static void startGame() {
        Random random = new Random();
        ArrayList<String> celebrationText = new ArrayList<>();
        celebrationText.add("Brilliant, amazing stuff!");
        celebrationText.add("Wow, you did it.");
        celebrationText.add("Well done, keep it up!");
        celebrationText.add("Congratulations, you doing great.");


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your guess below :");


        while (attempts <= 3) {
            numberGenerator();
            int guess = scanner.nextInt();
            if (guess == generatedNumber) {
                System.out.println(celebrationText.get((random.nextInt(0, celebrationText.size()))));
                if (attempts == 1) {
                    score += 3;
                    round++;
                }
                else if (attempts == 2) {
                    score += 2;
                    round++;
                } else {
                    score += 1;
                    round++;
                }
                if (score > 0) {
                    System.out.println("Welcome to round :" + round);
                    System.out.println("Current score :" + score);
                    startGame();
                }
            }
            else if (guess > generatedNumber) {
                System.out.println("Your guess is too high.");
                if(attempts < 3) {
                    System.out.println("Try again :");
                }
                else {
                    System.out.println("Sorry, but you have ran out of attempts");
                }
            }
            else {
                System.out.println("Your guess is too low.");
                if(attempts < 3) {
                    System.out.println("Try again :");
                }
                else {
                    System.out.println("Sorry, but you have ran out of attempts");
                }
            }
            attempts++;

        }

    }
}