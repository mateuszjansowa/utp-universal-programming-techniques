package _02_Kolekcje.Lists;

import java.util.*;

public class ListIteratorExample {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));

        ListIterator<String> iterator = list.listIterator();

        while (iterator.hasNext()) {
            System.out.println("Next: " + iterator.next());
        }

        while (iterator.hasPrevious()) {
            System.out.println("Previous: " + iterator.previous());
        }

        iterator.add("E");
        System.out.println("After iterator.add: " + list);

        iterator.previous();
        iterator.remove();
        System.out.println("After iterator.previous() + iterator.remove(): " + list);

        if (iterator.hasPrevious()) {
            iterator.previous();
            iterator.set("Z");
            System.out.println("After iterator.set: " + list);
        }
    }
}
