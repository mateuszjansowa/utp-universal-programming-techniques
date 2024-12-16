package _01_Strumienie.buforowanie;

import java.io.*;

public class BufferedExample {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\buforowanie\\log.json"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\buforowanie\\target.json")));

            String line;

            while((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
