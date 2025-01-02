package _02_Kolekcje.Zbiory;

import java.util.*;

public class SetsExamples {
    public static void main(String[] args) {
        // HashSet
        Set<String> set = new HashSet<>();
        set.add("Kot");
        set.add("Pies");
        set.add("Kot");
        System.out.println(set); // [Kot, Pies];

        // LinkedHashSet
        Set<String> hashSet = new LinkedHashSet<>();
        hashSet.add("Kot");
        hashSet.add("Pies");
        hashSet.add("Kot");
        hashSet.add("Zebra");
        System.out.println(hashSet); // [Kot, Pies, Zebra]

        // TreeSet
        final TreeSet<Player> ranking = new TreeSet<>();
        ranking.add(new Player("Mati", 19));
        ranking.add(new Player("Rita", 29));
        ranking.add(new Player("Franek", 9));

        ranking.forEach(System.out::println);
    }
}

class Player implements Comparable<Player> {
    private final String name;
    private final int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Player other) {
        return Integer.compare(other.score, this.score);
    }

    @Override
    public String toString() {
        return name + " - " + score + " pkt";
    }
}
