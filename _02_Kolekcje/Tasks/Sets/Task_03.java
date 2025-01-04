package _02_Kolekcje.Tasks.Sets;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Task_03 {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String next = in.next();

            if (next.equalsIgnoreCase("exit")) {
                break;
            }

            if (next.trim().isEmpty()) {
                continue; // ignoruje puste wejscia
            }

            set.add(next.toLowerCase());
        }

        in.close();

        System.out.println("Zbiór unikalnych elementów: " + set);
    }
}
