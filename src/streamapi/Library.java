package streamapi;

import java.util.ArrayList;
import java.util.List;

class Book{
    private int id;
    private String title;
    private int price;

    public Book(int id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
public class Library {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();

        list.add(new Book(1, "Effective Java", 800));
        list.add(new Book(2, "Clean Code", 650));
        list.add(new Book(3, "Head First Java", 550));
        list.add(new Book(4, "Spring in Action", 900));
        list.add(new Book(5, "Java : The Complete Reference", 750));
        list.add(new Book(6, "Design Patterns", 1000));

        list.stream()
                .filter(book -> book.getPrice() > 700)
                .map(Book::getTitle)
                .sorted()
                .toList()
                .forEach(System.out :: println);
    }
}