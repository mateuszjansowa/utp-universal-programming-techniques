package _03_Generics.Tasks;

import java.util.Collection;
import java.util.List;

public class Task_03 {
    public static <T extends Collection<?>> void printCollection(T collection) {
        System.out.println(collection);
    }

    public static <T extends Collection<? extends Number>> double sumNumbers(T collection) {
        double sum = 0;

        for (Number entry : collection) {
            sum += entry.doubleValue();
        }

        return sum;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 20, 30);
        printCollection(numbers);
        sumNumbers(numbers);
    }
}
