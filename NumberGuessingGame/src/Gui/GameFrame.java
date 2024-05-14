package Gui;

import Game.NumberGuessingGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameFrame extends JFrame implements ActionListener {
    private Container container;
    private JLabel title;
    private JLabel score;
    private JLabel round;
    private JLabel remainingTries;
    private JLabel randomNum;
    private JTextArea userGuess;
    private JButton playGame;
    private JButton submit;

    NumberGuessingGame game = new NumberGuessingGame();
    int min = 1, max = 100;
    Random random = new Random();
    int attempts = 1, gameRound = 1, gameScore = 0, generatedNumber = random.nextInt(min, max);

    public GameFrame() {
        setTitle("Number Guessing Game");
        setBounds(300,90,900,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        container = getContentPane();
        container.setLayout(null);

        title = new JLabel("Number Guessing Game");
        title.setFont(new Font("Arial", Font.ITALIC, 50));
        title.setSize(100,100);
        title.setLocation(100,100);
        container.add(title);

        score = new JLabel(String.valueOf(game.getScore()));
        score.setFont(new Font("Arial", Font.BOLD, 30));
        score.setSize(30,30);
        score.setLocation(20,120);
        container.add(score);

        round = new JLabel(String.valueOf(game.getRound()));
        round.setFont(new Font("Arial", Font.BOLD, 30));
        round.setSize(30,30);
        round.setLocation(20,130);
        container.add(round);

        remainingTries = new JLabel(String.valueOf(game.getAttempts()));
        remainingTries.setFont(new Font("Arial", Font.BOLD, 30));
        remainingTries.setSize(30,30);
        remainingTries.setLocation(800,120);
        container.add(remainingTries);

        randomNum = new JLabel(String.valueOf(game.getGeneratedNumber()));
        randomNum.setFont(new Font("Arial", Font.BOLD, 30));
        randomNum.setSize(30,30);
        randomNum.setLocation(800,130);
        container.add(randomNum);

        userGuess = new JTextArea();
        userGuess.setFont(new Font("Arial", Font.PLAIN, 25));
        userGuess.setSize(200, 75);
        userGuess.setLocation(400, 300);
        userGuess.setLineWrap(true);
        container.add(userGuess);

        submit = new JButton("Enter");
        submit.setSize(60,50);
        submit.setLocation(20,350);
        container.add(submit);

        playGame = new JButton("Play");
        playGame.setAction(game.startGame(attempts,gameRound,gameScore, generatedNumber));
        playGame.setSize(80,60);
        playGame.setLocation(350, 240);
        container.add(playGame);


        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
