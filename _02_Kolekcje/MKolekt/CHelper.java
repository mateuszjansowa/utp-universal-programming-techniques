package _02_Kolekcje.MKolekt;

public interface CHelper<T> {
    T makeObject(String s); // tworzy obiekt na podstawie napisu, np. z pliku
    String makeString(); // tworzy napis z obiektu, np. by zapisac do pliku
    boolean isNotUpToDate(); // sprawdza czy obiekt jest nieaktualny
}
