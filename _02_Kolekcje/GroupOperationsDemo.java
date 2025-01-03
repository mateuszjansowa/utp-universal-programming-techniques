package _02_Kolekcje;

import java.util.*;

public class GroupOperationsDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Ala", "ma", "kota"));
        list.add("psa");
        Set<String> set = new HashSet<>(list);

        System.out.println("List: " + list);
        System.out.println("Set: " + set);

        list.removeAll(set);
        System.out.println("List.removeAll(set): " + list);

        list.addAll(set);
        System.out.println("List.addAll(set): " + list);

        Set<String> sortedSet = new TreeSet<>(list);
        System.out.println("TreeSet<>(list): " + sortedSet);

        String[] array = list.toArray(new String[0]);
        System.out.println("array: " + Arrays.toString(array));
    }
}
