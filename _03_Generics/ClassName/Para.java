package _03_Generics.ClassName;

public class Para<S, T> {
    private S first;
    private T last;

    public Para(S first, T last) {
        this.first = first;
        this.last = last;
    }

    public S getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }

    public static <T> void display(T element) {
        System.out.println(element);
    }

    public static void main(String[] args) {
        Para<String, Integer> para = new Para("Ala", 3);
        Para<Double, Para> secondPara = new Para(12.5, para);
        System.out.println(para.getFirst() + ", " + para.getLast());

        display(123);
    }
}
