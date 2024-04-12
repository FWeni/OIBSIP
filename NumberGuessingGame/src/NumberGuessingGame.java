import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public void startGame(int attempts, int round ,int score, int generatedNumber) {
        Random random = new Random();
        ArrayList<String> celebrationText = new ArrayList<>();
        celebrationText.add("Brilliant, amazing stuff!");
        celebrationText.add("Wow, you did it.");
        celebrationText.add("Well done, keep it up!");
        celebrationText.add("Congratulations, you doing great.");


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your guess below :");


        while (attempts <= 3) {
            int guess = scanner.nextInt();
            if (guess == generatedNumber) {
                System.out.println(celebrationText.get((random.nextInt(0, celebrationText.size()))));
                if (attempts == 1) {
                    score += 3;
                    round++;
                } else if (attempts == 2) {
                    score += 2;
                    round++;
                } else {
                    score += 1;
                    round++;
                }
                if (score > 0) {
                    System.out.println("Round " + round);
                    System.out.println("Score " + score);
                    startGame(attempts, round, score, generatedNumber);
                }
            } else if (guess > generatedNumber) {
                System.out.println("Your guess is too high.");
                if(attempts != 3) {System.out.println("Try again :");
                } else {
                    System.out.println("Sorry, but you have ran out of attempts");
//                    playAgain();
                }

            } else {
                System.out.println("Your guess is too low.");
                if(attempts != 3) {System.out.println("Try again :");
                } else {
                    System.out.println("Sorry, but you have ran out of attempts");
//                    playAgain();
                }

            }
            attempts++;

        }

    }
//    private void playAgain() {
//        Random random = new Random();
//        int min = 1, max =100;
//        int attempts = 1, round = 1, score = 0, generatedNumber = random.nextInt(min, max);
//
//        Scanner scanner = new Scanner(System.in);
//        String userDecision = scanner.nextLine();
//        System.out.println("(P)lay? \t \t (Q)uit?");
//
//        if (userDecision.equalsIgnoreCase("P")) {
//            startGame(attempts, round, score, generatedNumber);
//        } else {
//            System.out.println("Thank you for playing");
//        }
//    }

}
