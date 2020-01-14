package com.GUI;

import javax.swing.JLabel;
import java.util.Arrays;

public class AcakKata implements PenangananKata {
    private static String[] katabenar;
    private static String[] labelkata;
    private static Kamus kamus;
    private static JLabel kataLabel;

    public AcakKata(JLabel kataLabel){
        kamus = new Kamus();
        AcakKata.kataLabel = kataLabel;
    }

    @Override
    public void splitWord() {
        String temp = kamus.buatkamus();

        katabenar = (temp.toUpperCase().split("(?<=\\G.{1})"));
        labelkata = new String[katabenar.length];
        Arrays.fill(labelkata, "__ ");

        if(Arrays.asList(katabenar).contains(" ")){
            updateGuessedLetter("    ");
        }
        kataLabel.setText(getGuessedLetters());
    }

    private void updateGuessedLetter(String guessedLetter) {
        for(int a = 0; a < katabenar.length; a++){
            if(katabenar[a].equals(guessedLetter)){
                if(guessedLetter.equals(" ")){
                    labelkata[a] = "   ";
                } else{
                    labelkata[a] = guessedLetter;
                }
            }
        }
    }

    @Override
    public String getGuessedLetters() {
        String temp = "";
        for(int i = 0; i < katabenar.length; i++){
            temp += labelkata[i];
        }
        return temp;
    }

    @Override
    public String getCorrectWord() {
        String temp = "";
        for(int i = 0; i < katabenar.length; i++){
            temp += katabenar[i];
        }
        return temp;
    }

    @Override
    public boolean guessLetter(String guessedLetter) {
        guessedLetter = guessedLetter.toUpperCase();
        if(Arrays.asList(katabenar).contains(guessedLetter)){
            updateGuessedLetter(guessedLetter);
            return true;
        }

        return false;
    }

    @Override
    public boolean matchingWords() {
        String correct = "";
        String guessedWord = "";
        for(int i = 0; i < labelkata.length; i++){
            if(labelkata[i].equals("   ")){
                guessedWord += " ";
            } else{
                guessedWord += labelkata[i];
            }
            correct += katabenar[i];
        }
        return guessedWord.equals(correct);
    }
}
