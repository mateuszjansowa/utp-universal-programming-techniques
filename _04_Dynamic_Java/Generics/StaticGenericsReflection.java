package _04_Dynamic_Java.Generics;

import java.lang.reflect.Type;

public class StaticGenericsReflection {
    private Para<String, Integer> p1 = new Para<>("Hello", 42);

    public StaticGenericsReflection() {
        try {
            // Surowy typ dynamiczny
            System.out.println("Surowy typ dynamiczny: " + p1.getClass());

            // Statyczny typ pola
            Type type = getClass().getDeclaredField("p1").getGenericType();
            System.out.println("Statyczny typ pola p1: " + type);
            // Statyczny typ pola p1: _04_Dynamic_Java.Generics.Para<java.lang.String, java.lang.Integer>

            // Pobieranie generycznego typu nadklasy
            Type genericSuperclass = p1.getClass().getGenericSuperclass();
            System.out.println("Typ nadklasy: " + genericSuperclass);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StaticGenericsReflection();
    }
}

class Para<T, S> {
    private T first;
    private S second;

    public Para(T first, S second) {
        this.first = first;
        this.second = second;
    }
}