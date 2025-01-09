package _04_Dynamic_Java.Classes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Podaj pełną nazwę klasy: ");
            String className = scanner.nextLine().trim();

            try {
                Class<?> actionClass = Class.forName("_04_Dynamic_Java.Classes." + className); // dynamiczne załadowanie klasy
                Object instance = actionClass.getDeclaredConstructor().newInstance(); // dynamiczne tworzenie obiektu

                if (instance instanceof ActionHandler) {
                    ActionHandler handler = (ActionHandler) instance;
                    handler.execute(); // wykonanie akcji, jesli wpisana klasa implementuje interfejs ActionHandler
                } else {
                    System.out.println("Klasa nie implementuje interfejsu ActionHandler");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
