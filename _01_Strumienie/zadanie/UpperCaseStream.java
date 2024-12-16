package _01_Strumienie.zadanie;

import java.io.*;

public class UpperCaseStream {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\zadanie\\input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\zadanie\\output.txt"));

            int c;

            while((c = reader.read()) != -1) {
                writer.write(Character.toUpperCase(c));
            }

            reader.close();
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
