package _02_Kolekcje.Tasks.Maps;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Task_02 {
    public static void main(String[] args) {
        Map<String, Integer> words = new HashMap<>();

        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                String input = in.nextLine().trim();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                String wordsArray[] = input.split("\\s+");

                for (String word : wordsArray) {
                   words.put(word, words.getOrDefault(word, 0) + 1);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(words);
    }
}
