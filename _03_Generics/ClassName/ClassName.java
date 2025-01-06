package _03_Generics.ClassName;

public class ClassName<T> {
    private T data;

    public ClassName(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public static void main(String[] args) {
        ClassName className = new ClassName(new Object());

        System.out.println(className.getData());
    }
}
