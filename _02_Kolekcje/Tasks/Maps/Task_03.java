package _02_Kolekcje.Tasks.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_03 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Dodaj drużynę (nazwa punkty): ");

            while (true) {
                String input = in.nextLine().trim();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                String words[] = input.split(" ");

                if (words.length != 2) {
                    System.out.println("Błędny format danych");
                    continue;
                }

                String name = words[0];
                int points = Integer.parseInt(words[1]);

                map.put(name, points);
                System.out.println("Dodano/aktualizowano: " + name + " -> " + points);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Tabela:");
        map.forEach((team, points) -> System.out.println(team + " : " + points));
    }
}
