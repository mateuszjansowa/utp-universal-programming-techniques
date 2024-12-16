package _01_Strumienie.operacje;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharOperation {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\operacje\\input.txt\"");
            FileWriter fileWriter = new FileWriter("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\operacje\\output.txt\"");

            int c;

            while((c = fileReader.read()) != -1) {
                fileWriter.write(c);
            }

            fileReader.close();
            fileWriter.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
