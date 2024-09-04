package main;

import javax.swing.*;

/**
 * It is a good practice to have a main.Main class that creates the JFrame and sets it visible.
 */
public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);//center the window
        window.setVisible(true);

        gamePanel.setupGame();

        gamePanel.startGameThread();
    }
}