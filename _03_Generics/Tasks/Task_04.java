package _03_Generics.Tasks;

import java.util.HashMap;
import java.util.Map;

public class Task_04 {
    public static void main(String[] args) {
        Warehouse<Integer> warehouse = new Warehouse<>();
        warehouse.addProduct(new Product<>(1, "Laptop", 5));
        warehouse.addProduct(new Product<>(2, "Phone", 10));
        warehouse.updateQuantity(1, 7);
        warehouse.displayAll();
    }
}

class Product<T> {
    private final T id;
    private final String name;
    private int quantity;

    public Product(T id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public T getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity below 0. Provide correct value");
        }
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", name=" + name + ", quantity=" + quantity + "]";
    }
}

class Warehouse<T> {
    private final Map<T, Product<T>> products = new HashMap<>();

    public void addProduct(Product<T> product) {
        if (products.containsKey(product.getId())) {
            throw new IllegalArgumentException("Product already in the warehouse");
        }

        T id = product.getId();
        products.put(id, product);
    }

    public Product<T> getProduct(T id) {
        if (!products.containsKey(id)) {
            throw new IllegalArgumentException("No product with given id found!");
        }

        return products.get(id);
    }

    public void updateQuantity(T id, int newQuantity) {
        if (!products.containsKey(id)) {
            throw new IllegalArgumentException("No product with given id found!");
        }

        Product<T> product = products.get(id);
        product.setQuantity(newQuantity);
    }

    public void displayAll() {
        products.values().forEach(System.out::println);
    }
}