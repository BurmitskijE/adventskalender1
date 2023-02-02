package org.example;

import java.io.*;
import java.util.Scanner;

public class day2 {

    private static int getRoundScore(char opponent, char choice) {
        int score = 0;
        if (opponent == 'A' && choice == 'X') {
        score = 1+3;
        }
        else if ( opponent == 'A' && choice == 'Y') {
            score = 2+6;
        }
        else if (opponent == 'A' && choice == 'Z') {
            score = 3;
        }
        else if (opponent == 'B' && choice == 'X'){
            score = 1;
        }
        else if (opponent == 'B' && choice == 'Y'){
            score = 2+3;
        }
        else if (opponent == 'B' && choice == 'Z'){
            score = 3+6;
        }
        else if (opponent == 'C' && choice == 'X' ){
            score = 1+6;
        }
        else if (opponent == 'C' && choice == 'Y' ){
            score = 2;
        }
        else if (opponent == 'C' && choice == 'Z' ){
            score = 3+3;
        }
        return score;
    }
    public static void main(String[] args) {
        int totalScore = 0;
        try {
            Scanner sc = new Scanner(new File("input1.txt"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                char opponent = line.charAt(0);
                char choice = line.charAt(2);
                int roundScore = getRoundScore(opponent, choice);
                totalScore +=roundScore;
            }
            System.out.println("Total Score: " + totalScore);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
