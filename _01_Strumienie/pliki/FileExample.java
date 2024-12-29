package _01_Strumienie.pliki;

import java.io.File;

public class FileExample {
    public static void main(String[] args) {
        File file = new File("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\pliki\\file.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists!");
            }

            System.out.println("Path: " + file.getPath());
            System.out.println("Is directory: " + file.isDirectory());
            System.out.println("Can read: " + file.canRead());
            System.out.println("Can write: " + file.canWrite());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
