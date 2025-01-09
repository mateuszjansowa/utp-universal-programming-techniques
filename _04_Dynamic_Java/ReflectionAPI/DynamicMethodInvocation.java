package _04_Dynamic_Java.ReflectionAPI;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class DynamicMethodInvocation {
    public static void main(String[] args) {
        try {
            ArrayList<String> list = new ArrayList<>();
            Class<?> loadedClass = list.getClass();

            // dodanie elementu do listy za pomocą refleksji
            Method addMethod = loadedClass.getMethod("add", Object.class);
            addMethod.invoke(list, "Hello from reflection");

            System.out.println("List after reflection: " + list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
