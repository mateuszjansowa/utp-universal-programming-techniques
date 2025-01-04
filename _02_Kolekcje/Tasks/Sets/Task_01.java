package _02_Kolekcje.Tasks.Sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Task_01 {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>(Set.of("Japko", "Banan", "Morela", "Truskawka", "Gruszka", "Brzoskwinka"));
        Iterator<String> iterator = fruits.iterator();

        while (iterator.hasNext()) {
            String fruit = iterator.next();

            if (fruit.startsWith("B")) {
                iterator.remove();
            }
        }

//        lub
//        fruits.removeIf(fruit -> fruit.startsWith("B"));

        System.out.println(fruits);
    }
}
