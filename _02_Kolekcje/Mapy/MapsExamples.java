package _02_Kolekcje.Mapy;

import java.util.*;

public class MapsExamples {
    public static void main(String[] args) {
        // HashMap
        Map<String, String> map = new HashMap<>();
        map.put("Polska", "Warszawa");
        map.put("Francja", "Paryż");
        System.out.println(map.get("Polska")); // Warszawa

        // LinkedHashMap
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Polska", "Warszawa");
        linkedHashMap.put("Francja", "Paryż");
        System.out.println(linkedHashMap); // {Polska=Warszawa, Francja=Paryż}

        // TreeMap
        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("Francja", "Paryż");
        treeMap.put("Polska", "Warszawa");
        System.out.println(treeMap); // {Francja=Paryż, Polska=Warszawa}

        // WeakHashMap
        Map<Object, String> weakHashMap = new WeakHashMap<>();
        Object key = new Object();
        weakHashMap.put(key, "Value");

        key = null;
        System.gc();
        System.out.println(weakHashMap); // {}
    }
}
