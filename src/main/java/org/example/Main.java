package org.example;

import java.io.*;
import java.util.*;

class Elf {
    int calories;

    public Elf(int calories) {
        this.calories = calories;
    }

    public int getCalories() {
        return this.calories;
    }
}

public class Main {
    public static ArrayList<Elf> arrayifyCalories(String inputFile) {
        ArrayList<Elf> array = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;
            int sumCalories = 0;

            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    array.add(new Elf(sumCalories));
                    sumCalories = 0;
                } else {
                    sumCalories += Integer.parseInt(line.strip());
                }
            }
            array.add(new Elf(sumCalories));
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static int sumOfHighestThree(ArrayList<Elf> array) {
        array.sort((a, b) -> Integer.compare(b.getCalories(), a.getCalories()));
        int sumOfCalories = 0;

        for (int i = 0; i < 3; i++) {
            sumOfCalories += array.get(i).getCalories();
        }
        return sumOfCalories;
    }

    public static void main(String[] args) {
        ArrayList<Elf> calorieList = arrayifyCalories("input.txt");
        Elf maxElf = calorieList.stream().max((a, b) -> Integer.compare(a.getCalories(), b.getCalories())).get();
        int index = calorieList.indexOf(maxElf);
        System.out.println("Elf no. " + (index + 1) + " is the Elf with the most calories. He carries " + maxElf.getCalories() + " calories");
        //Teil 2

        int sum = sumOfHighestThree(calorieList);
        System.out.println("The three richest Elves are carrying a total of " + sum + " calories");
    }
}