package _04_Dynamic_Java.Classes;

public class AnotherExample {
    public static void main(String[] args) {
        try {
            Class<?> loadedClass = Class.forName("java.util.ArrayList");
            System.out.println("Loaded class: " + loadedClass.getName());

            Object instance = loadedClass.getDeclaredConstructor().newInstance();
            System.out.println("Instance created: " + instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
