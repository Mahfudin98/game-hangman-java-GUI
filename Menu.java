package com.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private static JFrame gamewindow;

    public Menu(JFrame gamewindow){
        Menu.gamewindow = gamewindow;
    }

    public static void makeMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        JMenu gameMenu = new JMenu("Menu Game");
        menuBar.add(gameMenu);

        JMenuItem play = new JMenuItem("Play Game");
        gameMenu.add(play);
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.permainan();
            }
        });
        JMenuItem help = new JMenuItem("Instruction Game");
        gameMenu.add(help);
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.intruct();
            }
        });
        JMenuItem exit = new JMenuItem("Exit Game");
        gameMenu.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        gamewindow.setJMenuBar(menuBar);
    }
}
