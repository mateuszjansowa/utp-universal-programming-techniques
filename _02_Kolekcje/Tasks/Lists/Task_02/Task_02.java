package _02_Kolekcje.Tasks.Lists.Task_02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Task_02 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(2, 5, 8, 10, 3, 7, 4, 1, 6));

        list.sort(Integer::compareTo);

        int max = Collections.max(list);
        int min = Collections.min(list);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int number = iterator.next();
            if (number < 5) {
                iterator.remove();
            }
        }

        System.out.println(list);
    }
}
