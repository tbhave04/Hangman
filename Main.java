package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a word: ");
        String word = s.nextLine();

        Frame frame = new Frame(word);
    }
}
