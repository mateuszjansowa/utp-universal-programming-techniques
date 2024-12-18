package _01_Strumienie.strumienie_binarne;

import java.io.*;

public class BinData {
    public static void main(String[] args) {
        double[] a = {1, 2, 3, 4};
        double[] b = {5, 6};

        Obs obsA = new Obs("Dane A", a);
        Obs obsB = new Obs("Dane B", b);

        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\strumienie_binarne\\dane.bin"));
            obsA.writeTo(out);
            obsB.writeTo(out);
            out.close();

            DataInputStream in = new DataInputStream(new FileInputStream("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\strumienie_binarne\\dane.bin"));
            new Obs().readFrom(in).show(); // strumien odczytuje dane A
            new Obs().readFrom(in).show(); // strumien odczytuje dane B (tam gdzie skonczyl poprzedni)
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
