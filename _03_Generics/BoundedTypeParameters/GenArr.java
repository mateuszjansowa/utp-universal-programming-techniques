package _03_Generics.BoundedTypeParameters;

public class GenArr<T extends Comparable<T>> {
    private T[] arr;

    public GenArr(T[] arr) {
        this.arr = arr;
    }

    public T findMax() {
        T max = arr[0];
        for (T element : arr) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        GenArr<Integer> intArr = new GenArr<>(new Integer[]{1, 2, 3});
        System.out.println("Max: " + intArr.findMax());
    }
}
