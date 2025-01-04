package _02_Kolekcje.Tasks.Sets;

import java.util.HashSet;
import java.util.Set;

public class Task_02 {
    public static void main(String[] args) {
        Set<Integer> firstSet = new HashSet<>();
        for (int i = 2; i <= 20; i += 2) {
            firstSet.add(i);
        }

        Set<Integer> secondSet = new HashSet<>();
        for (int i = 10; i <= 30; i++) {
            secondSet.add(i);
        }

        secondSet.retainAll(firstSet);
        System.out.println(secondSet);
    }
}
