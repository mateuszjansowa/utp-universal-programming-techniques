package _01_Strumienie.pliki;

import java.io.RandomAccessFile;

public class RandomAccessExample {
    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\pliki\\data.txt", "rw");
            raf.writeUTF("Hello, world!");
            raf.seek(0);

            String data = raf.readUTF();
            System.out.println("Read from file: " + data);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
