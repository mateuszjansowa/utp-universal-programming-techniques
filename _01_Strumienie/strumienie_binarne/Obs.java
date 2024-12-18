package _01_Strumienie.strumienie_binarne;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Obs {
    String name;
    double[] data;
    int n;

    public Obs() {

    }

    public Obs(String name, double[] data) {
        this.name = name;
        this.data = data;
    }

    public void writeTo(DataOutputStream dout) throws IOException {
        dout.writeUTF(name); // zapis nazwy
        dout.writeInt(data.length); // zapis długości tablicy
        for (double d : data) {
            dout.writeDouble(d); // zapis każdego elementu tablicy
        }
    }

    public Obs readFrom(DataInputStream dit) throws IOException {
        name = dit.readUTF(); // odczyt nazwy
        int n = dit.readInt(); // odczyt długości tablicy
        data = new double[n];

        for (int i = 0; i < n; i++) {
            data[i] = dit.readDouble(); // odczyt każdego elementu
        }

        return this; // konwencja Fluent API (np. mozliwosc wykonania new Obs().readFrom(in).show())
    }

    public void show() {
        System.out.println(name);
        for(double d : data) {
            System.out.println(d + " ");
        }
        System.out.println();
    }
}
