package _02_Kolekcje.MKolekt;

import java.io.File;
import java.util.Collection;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Scanner;

public class MKolekt {
    // odczytuje dane z pliku, na podstawie lini tworzy obiekty, dodaje je do kolekcji col
    public static <T extends CHelper<T>> void makeCollectionFromFile(Collection<T> col, String fname, Class<T> klasaOb) {
        try {
            CHelper<T> mgr = klasaOb.newInstance(); // tworzy obiekt klasy T
            Scanner in = new Scanner(new File(fname));

            while (in.hasNextLine()) {
                T obj = mgr.makeObject(in.nextLine()); // tworzy obiekt z danej linii pliku
                col.add(obj);
            }

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // przeglada kolekcje, usuwa elementy z warunkiem isNotUpToDate
    public static <T extends CHelper<T>> void iterRemove(Collection<T> c) {
        Iterator<T> iter = c.iterator();
        while (iter.hasNext()) {
            T obj = iter.next();
            if (obj.isNotUpToDate()) iter.remove();
        }
    }

    // przeksztalca elementy kolekcji na napisy i zapisuje kazdy element w nowej linii pliku
    public static <T extends CHelper<T>> void writeToFile(Collection<T> col, String fname) throws Exception {
        Formatter out = new Formatter(new File(fname));
        for (T obj : col) {
            out.format("%s%n", obj.makeString()); // zapisuje obiekt do pliku
        }
        out.close();
    }

    public static void show(Collection<?> col) {
        for (Object o : col) System.out.println(o);
    }
}
