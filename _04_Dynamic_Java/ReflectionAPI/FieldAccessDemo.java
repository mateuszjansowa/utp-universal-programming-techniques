package _04_Dynamic_Java.ReflectionAPI;

import java.lang.reflect.Field;

class Person {
    private final String name = "Very private";
}

public class FieldAccessDemo {
    public static void main(String[] args) {
        try {
            Person person = new Person();
            Class<?> clazz = person.getClass();

            Field nameField = clazz.getDeclaredField("name");
            nameField.setAccessible(true); // omijanie ograniczen dostepu

            String name = (String) nameField.get(person);
            System.out.println("Name before: " + name);

            nameField.set(person, "Not so private...");
            System.out.println("Name after: " + nameField.get(person));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
