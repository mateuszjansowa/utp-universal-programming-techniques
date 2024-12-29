package _01_Strumienie.serializacja;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Travel implements Serializable {
    protected String destination;
    private int price;

    public Travel(String destination, int price) {
        this.destination = destination;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "destination='" + destination + '\'' +
                ", price=" + price +
                '}';
    }
}

class TravelSearcher implements Serializable {
    private List<Travel> travels = new ArrayList<>();

    public void addTravel(Travel travel) {
        travels.add(travel);
    }

    public Travel findTravel(String destination) {
        return travels.stream()
                .filter(t -> t.destination.equalsIgnoreCase(destination))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "TravelSearcher{" + "travels=" + travels + "}";
    }
}

public class TravelApp {
    public static void main(String[] args) {
        TravelSearcher searcher = new TravelSearcher();
        searcher.addTravel(new Travel("Cyprus", 1500));
        searcher.addTravel(new Travel("Crete", 1750));

        // Serializacja
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\serializacja\\travels.ser"));
            oos.writeObject(searcher);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserializacja
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\coding\\Java\\UTP\\src\\_01_Strumienie\\serializacja\\travels.ser"));
            TravelSearcher deserializedSearcher = (TravelSearcher) ois.readObject();
            System.out.println("Odczytano: " + deserializedSearcher);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
