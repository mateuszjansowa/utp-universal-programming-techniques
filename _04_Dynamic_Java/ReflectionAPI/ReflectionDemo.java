package _04_Dynamic_Java.ReflectionAPI;

import java.lang.reflect.Method;

public class ReflectionDemo {
    public static void main(String[] args) {
        try {
            Class<?> loadedClass = Class.forName("java.util.ArrayList");

            // wypisanie wszystkich metod

            Method[] methods = loadedClass.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("Method: " + method.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
