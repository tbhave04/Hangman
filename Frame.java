package com.company;
import javax.swing.JFrame;
public class Frame {
    public Frame(String word){
        JFrame frame = new JFrame("Hangman");
        frame.setSize(600, 600);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Panel(word));
        frame.setVisible(true);
    }
}
