package _03_Generics.Konkludowanie;

public class Example {
    public static <T> void display(T value) {
        System.out.println(value);
    }

    public static <T extends Comparable<T>> T max(T[] array) {
        T max = array[0];
        for (T element : array) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3};
        int max = max(numbers); // T -> Integer
    }
}
