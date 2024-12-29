package _01_Strumienie.Tasks._02;

import java.io.*;
import java.util.List;

public class Task {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Alice", 25, "alice@example.com"),
                new Person("Bob", 30, "bob@example.com"),
                new Person("Charlie", 35, "charlie@example.com")
        );

        // serializacja
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\Tasks\\_02\\data.ser"));
            oos.writeObject(people);
            oos.close();
        } catch (IOException e) {
            System.err.println("Error with serialization: " + e.getMessage());
        }

        // deserializacja
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\Tasks\\_02\\data.ser"));
            @SuppressWarnings("unchecked") // Bezpieczne rzutowanie
            List<Person> deserializedList = (List<Person>) ois.readObject();
            System.out.println(deserializedList);
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error with deserialization: " + e.getMessage());
        }
    }
}

class Person implements Serializable {
    private String name;
    private int age;
    private String email;

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}