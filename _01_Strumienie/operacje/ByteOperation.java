package _01_Strumienie.operacje;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteOperation {
    public static void main(String[] args) throws IOException {
        try {
            FileInputStream in = new FileInputStream("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\operacje\\input.txt");
            FileOutputStream out = new FileOutputStream("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\operacje\\output.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
