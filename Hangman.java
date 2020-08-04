package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Hangman {
    int turns = 1;
    String wordArray;
    Map<String, ArrayList> d = new HashMap<String, ArrayList>();
    String[] fillArray;
    String used = "";

    public Hangman(String word){
        wordArray = word;
        fillArray = new String[word.length()];

        for(int i = 0; i<word.length(); i++){
            String letter = "" + word.charAt(i);
            ArrayList<Integer> a;
            if(d.containsKey(letter)==false){
                a = new ArrayList();
                a.add(i);
            }
            else{
                a = d.get(letter);
                a.add(i);
                d.remove(letter);
            }
            d.put(letter,a);
        }


        for(int i = 0; i<word.length(); i++){
            fillArray[i] = "" + "_";
        }
    }

    public boolean hasNextTurn(){
        boolean found = false;
        for(int i = 0; i<fillArray.length; i++){
            if(fillArray[i].equals("_")){
                found = true;
            }
        }

        if(found==false){
            return false;
        }
        return true;
    }

    public void doTurn(String letter){
        boolean found = false;

        if(d.containsKey(letter)==true){
            ArrayList<Integer> values = d.get(letter);
            for(int idx : values){
                fillArray[idx] = letter;
            }
            found = true;
        }

        if(found==false){
            turns = turns + 1;
        }

        used = used + " " + letter;
    }

    public String arrayToString(String[] array){
        String s = "";
        for(int i = 0; i<array.length; i++){
            s = s + array[i] + " ";
        }
        return s;
    }
}
