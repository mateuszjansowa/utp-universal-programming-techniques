package _03_Generics.Wildcards;

import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        // biwariancja - ackeptuje dowolny typ
        ArrayList<?> list = new ArrayList<String>(List.of("Ala"));

        // kowariancja - odczyt danych
        List<? extends Double> numbers = new ArrayList<>(List.of(1.2, 2.1));
//        numbers.add(3.4); niedozwolone

        // Kontrawariancja - zapis elementow
        List<? super Integer> intNumbers = new ArrayList<Number>();
        intNumbers.add(12);
    }
}
