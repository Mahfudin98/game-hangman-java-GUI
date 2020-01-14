package com.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Keyboard {
    private static JPanel content;
    private static int jawab;
    private static PenangananKata PK;
    private static JLabel kataLabel;
    private static JFrame gameWindow;
    private static int ran;
    private static JLabel textLabel = new JLabel("", SwingConstants.CENTER);
    private static int i=0;
    private static Random text;
    private static JButton[] buttons;
    private static String[] charachters = {"q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m"};

    public Keyboard(JPanel content, PenangananKata PK, JLabel kataLabel, JFrame gameWindow){
        Keyboard.content = content;
        Keyboard.PK = PK;
        Keyboard.kataLabel = kataLabel;
        Keyboard.gameWindow = gameWindow;
        textLabel.setSize(700,250);
        i = 0;
    }

    public void createKeyboard(){
        final JPanel panel = new JPanel(new GridLayout(3,10));

        Font f = new Font("SansSerif", Font.PLAIN, 15);
        UIManager.put("Button.font", f);

        buttons = new JButton[30];
        for(int i = 0; i < buttons.length; i++){
            if(i >= 26){
                buttons[i] = new JButton(" ");
                buttons[i].setEnabled(false);
                buttons[i].setBackground(Color.DARK_GRAY);
            }else{
                buttons[i] = new JButton(charachters[i].toUpperCase());
            }
            final String temp = buttons[i].getText().toLowerCase();
            final int placement = i;
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    checkLetter(temp, placement);
                }
            });
            panel.add(buttons[i]);
        }
        panel.setPreferredSize(new Dimension(600,120));
        panel.setBackground(Color.LIGHT_GRAY);
        content.add(panel, BorderLayout.SOUTH);
    }

    public static String[] getButtons(){
        return charachters;
    }

    static void checkLetter(String temp, int placement) {
        if(buttons[placement].isEnabled()){
            if(PK.guessLetter(temp)){
                penulisKata();
                if(PK.matchingWords()){
                    for(int a = 0; a < buttons.length; a++){
                        buttons[a].setEnabled(false);
                        buttons[a].setBackground(Color.green);
                        JFrame ulang = new JFrame();
                        ulang.setTitle("Titel");
                        jawab = JOptionPane.showOptionDialog(ulang,
                                "Kamu berhasil, ingin Mengulang?",
                                "Ulangi",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, null, null);

                        if(jawab == JOptionPane.YES_OPTION){
                            JOptionPane.showMessageDialog(ulang, "Mengulang Permainan");
                            Game.permainan();
                        }else {
                            System.exit(1);
                        }
                    }
                }
            }else{
                if(!kataSalah()){
                    for(int a = 0; a < buttons.length; a++){
                        buttons[a].setEnabled(false);
                        buttons[a].setBackground(Color.red);
                    }
                    kataLabel.setText(PK.getCorrectWord());
                    JFrame ulang = new JFrame();
                    ulang.setTitle("Titel");
                    jawab = JOptionPane.showOptionDialog(ulang,
                            "kamu gagal, ingin mengulang?",
                            "Ulangi",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, null, null);

                    if(jawab == JOptionPane.YES_OPTION){
                        JOptionPane.showMessageDialog(ulang, "Mengulang Permainan");
                        Game.permainan();
                    }else {
                        System.exit(1);
                    }
                }
            }
            buttons[placement].setEnabled(false);
            buttons[placement].setBackground(Color.lightGray);

            gameWindow.requestFocusInWindow();
        }
    }

    private static boolean kataSalah() {
        String[] stringList = {"Anda Salah", "Coba Lagi", "Huruf tidak ada!"};

        text = new Random();
        ran = text.nextInt(stringList.length);
        textLabel.setText(stringList[ran]);
        JFrame lose = new JFrame();
        lose.setTitle("Titel");
        JOptionPane.showMessageDialog(lose, textLabel);
        i++;

        if(i > 5){
            JFrame loseWindow = new JFrame();
            loseWindow.setTitle("Titel");
            JOptionPane.showMessageDialog(loseWindow, "Kamu Gagal!!!");
            return false;
        }
        return true;
    }

    private static void penulisKata() {
        kataLabel.setText(PK.getGuessedLetters());
    }
}
