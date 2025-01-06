package _02_Kolekcje.Tasks.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_01 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        System.out.println("1. Dodaj/aktualizuj kontakt\n" +
                "2. Wyszukaj numer\n" +
                "3. Wyświetl wszystkie kontakty\n" +
                "4. Wyjście");

        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                System.out.print("Wybierz opcję: ");
                String input = in.nextLine().trim();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                int selectedOption = Integer.parseInt(input);

                switch (selectedOption) {
                    case 1 -> {
                        System.out.print("Podaj imię: ");
                        String name = in.nextLine().trim();
                        System.out.print("Podaj nr telefonu: ");
                        String phoneNumber = in.nextLine().trim();

                        map.put(name, phoneNumber);
                        System.out.println("Dodano/aktualizowano kontakt: " + name + " -> " + phoneNumber);
                    }
                    case 2 -> {
                        System.out.print("Podaj imię: ");
                        String name = in.nextLine().trim();

                        String phoneNumber = map.getOrDefault(name, "-");
                        System.out.println("Kontakt: " + name + " -> " + phoneNumber);
                    }
                    case 3 -> {
                        map.forEach((name, number) -> System.out.println(name + " -> " + number));
                    }
                    default -> {
                        continue;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
