package com.GUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Kamus {
    private final static  String FILENAME = "KamusKata.txt";
    private static boolean kamusukur = false;
    private static int ukurankamus = 0;
    private static String kataterakhir = "";

    public Kamus(){
    }

    public String buatkamus(){
        BufferedReader file = null;
        String hangmanWord = kataterakhir;
        try {
            //Checks the size of the dictionary iff it has not been checked in the game already.
            if(kamusukur == false){
                ukurankamus = ukurankamus(file);
            }

            while(hangmanWord.equals(kataterakhir)){
                hangmanWord = readLineInDictionary(file);
            }

        } catch (IOException e) {
        }

        kataterakhir = hangmanWord;
        return hangmanWord;
    }

    private int ukurankamus(BufferedReader file) throws IOException{
        file = new BufferedReader(new FileReader(FILENAME));

        int numbaris = 0;
        while ((file.readLine()) != null){
            numbaris++;
        }

        if (file != null){
            file.close();
        }

        kamusukur = true;
        return numbaris;
    }

    private String readLineInDictionary(BufferedReader file) throws IOException{
        file = new BufferedReader(new FileReader(FILENAME));

        Random random = new Random();
        String baris;
        int barisbenar = 0;
        int randnum = random.nextInt(ukurankamus);

        while ((baris = file.readLine()) != null && barisbenar != randnum){
            barisbenar++;
        }

        if (file != null){
            file.close();
        }

        return baris.toLowerCase();
    }
}
