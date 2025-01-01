package _02_Kolekcje.MKolekt;

import java.util.ArrayList;
import java.util.List;

public class Journal implements CHelper<Journal> {
    private String title;
    private int year;
    private static int retainAfter = 2000;

    // Konstruktor bezparametrowy (wymagany przez newInstance())
    public Journal() {
        this.title = "";
        this.year = 0;
    }

    public Journal(String title, int year) {
        this.title = title;
        this.year = year;
    }

    @Override
    public Journal makeObject(String s) {
        String title = "";
        int year = -1;
        try {
            String[] parts = s.split(" ");
            title = parts[0].replace("\"", "");
            year = Integer.parseInt(parts[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Journal(title, year);
    }

    @Override
    public String makeString() {
        return "\"" + title + "\" " + year;
    }

    @Override
    public boolean isNotUpToDate() {
        return year < retainAfter;
    }

    public int compareTo(Journal o) {
        return this.year - o.year;
    }

    @Override
    public String toString() {
        return title + " " + year;
    }

    public static void main(String[] args) {
        List<Journal> journals = new ArrayList<>();

        MKolekt.makeCollectionFromFile(journals, "D:\\coding\\Java\\UTP\\src\\_02_Kolekcje\\MKolekt\\journals.txt", Journal.class);

        System.out.println("Zawartość przed usunięciem: ");
        MKolekt.show(journals);

        MKolekt.iterRemove(journals);

        System.out.println("Zawartość po usunięciu: ");
        MKolekt.show(journals);

        try {
            MKolekt.writeToFile(journals, "D:\\coding\\Java\\UTP\\src\\_02_Kolekcje\\MKolekt\\journals_out.txt");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
