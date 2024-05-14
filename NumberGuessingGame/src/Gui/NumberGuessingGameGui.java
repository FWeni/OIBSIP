package Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGuessingGameGui {
    public void gameGui(){
        JFrame frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        JButton button = new JButton("Play");
        frame.getContentPane().add(button);
        frame.setVisible(true);

        button.getAction();
    }
}

