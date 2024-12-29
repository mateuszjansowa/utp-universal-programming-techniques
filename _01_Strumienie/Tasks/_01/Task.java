package _01_Strumienie.Tasks._01;

import java.io.*;

public class Task {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\Tasks\\_01\\input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\Tasks\\_01\\output.txt"));

            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                writer.write(String.format("%d: %s%n", lineNumber, line));
                lineNumber++;
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            System.err.println("Błąd podczas przetwarzania plików: " + e.getMessage());
        }
    }
}
