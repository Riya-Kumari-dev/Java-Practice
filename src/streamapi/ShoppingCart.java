package streamapi;

import java.util.ArrayList;
import java.util.List;

class CartItem{
    private String name;
    private int price;
    private int quantity;


    public CartItem(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
public class ShoppingCart {
    public static void main(String[] args) {
        List<CartItem> list = new ArrayList<>();

        list.add(new CartItem("Laptop", 50_000, 1));
        list.add(new CartItem("Mouse", 500, 2));
        list.add(new CartItem("Keyboard", 1500, 1));
        list.add(new CartItem("Headphones", 2500, 2));
        list.add(new CartItem("USB Cables", 200, 3));

        System.out.println("Items with quantity greater than 1 : ");

        list.stream()
                .filter(item -> item.getQuantity() > 1)
                .forEach(System.out :: println);


        int totalCost = list.stream()
                .filter(item -> item.getQuantity() > 1)
                .map(item -> item.getPrice() * item.getQuantity())
                .reduce(0, (a, b) -> a+b);

        System.out.println("Total cost of selected items : "+totalCost);
    }
}