package _02_Kolekcje.Tasks.Lists.Task_01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Task_01 {
    public static void main(String[] args) {
        List<String> animalsList = new ArrayList<>(List.of("Kot", "Pies", "Słoń", "Alpaka", "Antylopa", "Koń"));
        animalsList.sort(String::compareTo);

        Iterator<String> iterator = animalsList.iterator();
        while (iterator.hasNext()) {
            String animal = iterator.next();
            if (animal.startsWith("A")) {
                iterator.remove();
            }
        }

        System.out.println(animalsList); // [Kot, Koń, Pies, Słoń]
    }
}
