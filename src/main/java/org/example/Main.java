package org.example;
import java.io.*;
import java.util.*;

class Elf {
    int calories;

    public Elf(int calories) {
        this.calories = calories;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        List<Elf> elves = new ArrayList<>();
        int sumCalories = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    elves.add(new Elf(sumCalories));
                    sumCalories = 0;
                } else {
                    sumCalories += Integer.parseInt(line.trim());
                }
            }
            elves.add(new Elf(sumCalories));
        }

        int maxCalories = Integer.MIN_VALUE;
        int maxElfIndex = -1;
        for (int i = 0; i < elves.size(); i++) {
            if (elves.get(i).calories > maxCalories) {
                maxCalories = elves.get(i).calories;
                maxElfIndex = i;
            }
        }
        System.out.println("Elf " + (maxElfIndex + 1) + " is carrying the most calories: " + maxCalories);
    }
}
