package _03_Generics.Tasks;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task_02 {
    public static <T extends Comparable<T>> Pair minMax(T[] numbers) {
        T min = Collections.min(Arrays.asList(numbers));
        T max = Collections.max(Arrays.asList(numbers));
        return new Pair<>(min, max);
    }

    public static void main(String[] args) {
        Integer[] numbers = {10, 20, 5, 30};
        Pair<Integer, Integer> result = minMax(numbers);
        System.out.println(result);
    }
}
