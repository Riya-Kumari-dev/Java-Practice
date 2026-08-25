package collections.generics;

public class BoundedGenerics {
    static void main(String[] args) {
        printNumber(10);
        printNumber(10.4);
        printNumber(100L);
         // printNumber("Riya"); // ❌
    }

    // T must be a Number or a child of Number class
    private static <T extends Number> void printNumber(T value) {
        System.out.println(value);
    }
}