package com.GUI;

import javax.swing.*;
import java.awt.*;

public class MainGame {
    private static JFrame gameWindow;
    private static JPanel content;

    public static void main(String[] args) {
        gameWindow = new JFrame();
        gameWindow.setSize(900,750);
        gameWindow.setTitle("Hangman Moch.Mahfudin Nawawi.M");
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        content = new JPanel(new BorderLayout(1,3));
        content.setBackground(Color.lightGray);

        gameWindow.getContentPane().add(content);

        gameWindow.setResizable(true);
        gameWindow.setVisible(true);

        new Game(gameWindow,content);
        Game.permainan();
    }
}
