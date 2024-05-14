import Game.NumberGuessingGame;
import Gui.GameFrame;
import Gui.NumberGuessingGameGui;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int min = 1, max = 100;
        Random random = new Random();
        NumberGuessingGame guessingGame = new NumberGuessingGame();
//        NumberGuessingGameGui gameGui = new NumberGuessingGameGui();
        GameFrame frame = new GameFrame();
        int attempts = 1, round = 1, score = 0, generatedNumber = random.nextInt(min, max);

        System.out.println("Welcome to the Number Guessing Game.");
        System.out.println("Please enter a number between 1 and 100.");
//        guessingGame.startGame(attempts, round, score, generatedNumber);
//        gameGui.gameGui();




    }
}