package streamapi;

import java.util.ArrayList;
import java.util.List;

class Product{
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + "}";
    }
}
public class ProductProcessing {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 55_000));
        products.add(new Product(2, "Mouse", 500));
        products.add(new Product(3, "Keyboard", 1500));
        products.add(new Product(4, "Monitor", 12_000));
        products.add(new Product(5, "Headphones", 2500));
        products.add(new Product(6, "Webcam", 1800));

        products.stream()
                .filter(product -> product.getPrice() > 2000) // select the products having price greater than 2000
                .sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())) // sort on the basis of selected item's price
                .forEach(System.out :: println);

    }
}