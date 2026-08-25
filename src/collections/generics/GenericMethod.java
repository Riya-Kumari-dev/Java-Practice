package collections.generics;

public class GenericMethod {
    static void main(String[] args) {
        print(100);
        print("Riya");
        print(2.3);
    }

    // a method can have its own type parameter
    private static <T> void print(T value) {
        System.out.println(value);
    }
}