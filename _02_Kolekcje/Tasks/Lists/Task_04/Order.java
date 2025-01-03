package _02_Kolekcje.Tasks.Lists.Task_04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Order {
    private int id;
    private String clientName;
    private double price;

    public Order() {
        this(0, "-", 0);
    }

    public Order(int id, String clientName, double price) {
        this.id = id;
        this.clientName = clientName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {
        Order order0 = new Order(1235, "Sowa", 1650.00);
        Order order1 = new Order(1236, "Nowak", 3410.99);
        Order order2 = new Order(1234, "Kowalski", 999.99);
        Order order3 = new Order(1234, "Krzystofiak", 9199.99);


        List<Order> orderList = new ArrayList<>(List.of(order0, order1, order2, order3));

        orderList.sort((o1, o2) -> Double.compare(o2.price, o1.price));

        Iterator<Order> iterator = orderList.iterator();

        while (iterator.hasNext()) {
            double price = iterator.next().price;
            if (price < 1000) {
                iterator.remove();
            }
        }

        for (Order order : orderList) {
            if (order.clientName.startsWith("K")) {
                System.out.println(order);
            }
        }
    }
}
