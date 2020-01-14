package com.GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class Game implements KeyListener {
    private static JFrame gameWindow;
    private static JPanel content;
    private static PenangananKata PK;
    private static JLabel kataLabel;
    private static Keyboard keyboard;
    private static JLabel labaelTitle = new JLabel("Tebak Nama Negara", SwingConstants.CENTER);

    public Game(JFrame gameWindow, JPanel content){
        Game.gameWindow = gameWindow;
        Game.content = content;
        gameWindow.addKeyListener(this);
    }

    public static void permainan(){
        content.removeAll();
        new Menu(gameWindow);
        Menu.makeMenuBar();

        labaelTitle.setText("Tebak Nama Negara");
        labaelTitle.setFont(new Font("Sansserif", Font.BOLD, 65));
        content.add(labaelTitle, BorderLayout.NORTH);


        kataLabel = new JLabel("", SwingConstants.CENTER);
        kataLabel.setFont(new Font("Sansserif", Font.PLAIN, 45));
        kataLabel.setSize(800, 50);
        content.add(kataLabel, BorderLayout.CENTER);

        PK = new AcakKata(kataLabel);
        PK.splitWord();

        keyboard = new Keyboard(content, PK, kataLabel,gameWindow);
        keyboard.createKeyboard();

        content.revalidate();
    }

    public static void intruct(){
        JFrame helpWindow = new JFrame();
        helpWindow.setTitle("Intruction Game");
        JOptionPane.showMessageDialog(helpWindow, "Klik dalah satu huruf untuk menjawab");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        String guessedLetter = Character.toString(e.getKeyChar());
        if(guessedLetter.matches("^[a-zA-Z������]+$")){
            Keyboard.checkLetter(guessedLetter, Arrays.asList(Keyboard.getButtons()).indexOf(guessedLetter));
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
