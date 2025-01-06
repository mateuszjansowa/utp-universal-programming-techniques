package _03_Generics.BoundedTypeParameters;

public class Box<T extends Number> {
    private final T data;

    public Box(T data) {
        this.data = data;
    }

    public double calculateSquare() {
        return data.doubleValue() * data.doubleValue();
    }

    public static void main(String[] args) {
        Box<Integer> box = new Box<>(5);
        System.out.println(box.calculateSquare());
    }
}
