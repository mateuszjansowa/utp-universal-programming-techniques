package _01_Strumienie.kodowanie;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ByteToChar {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("file.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); // linia jako ciag znakow
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String osEncoding = System.getProperty("file.encoding");
        System.out.println("Default OS encoding: " + osEncoding); // UTF-8
    }
}
