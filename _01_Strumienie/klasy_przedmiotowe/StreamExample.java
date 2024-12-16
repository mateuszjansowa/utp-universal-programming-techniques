package _01_Strumienie.klasy_przedmiotowe;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StreamExample {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\klasy_przedmiotowe\\input.txt");
            FileWriter fileWriter = new FileWriter("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\klasy_przedmiotowe\\destination.txt");
            int character;

            while ((character = fileReader.read()) != -1) {
                fileWriter.write(character);
            }

            fileReader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
