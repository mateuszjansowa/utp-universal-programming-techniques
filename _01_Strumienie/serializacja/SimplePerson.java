package _01_Strumienie.serializacja;

import java.io.*;

class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Person{name=" + name + ", age=" + age + "}";
    }
}

public class SimplePerson {
    public static void main(String[] args) {
        Person person = new Person("Mati", 28);

        // Serializacja
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\serializacja\\person.ser"));
            oos.writeObject(person);
        } catch(IOException e) {
            e.printStackTrace();
        }

        // Deserializacja
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\serializacja\\person.ser"));
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("Odczytano: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
