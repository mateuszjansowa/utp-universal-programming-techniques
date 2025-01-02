package _02_Kolekcje.Mapy;

import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, String> countryCapital = new HashMap<>();
        countryCapital.put("Polska", "Warszawa");
        countryCapital.put("Francja", "Paryż");
        countryCapital.put("Liban", "Bejrut");

        for (String country : countryCapital.keySet()) {
            System.out.println(country + " -> " + countryCapital.get(country));
        }

        for (Map.Entry<String, String> entry : countryCapital.entrySet()) {
            System.out.println(entry.getKey() + " <-> " + entry.getValue());
        }
    }
}
