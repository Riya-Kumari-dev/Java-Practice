package OOPs.basic;

public class WrapperClass {
    static void main(String[] args) {
        int a = 10;
        System.out.println(a);
        // Boxing : Converting primitive data type into its corresponding wrapper class object
        Integer i = Integer.valueOf(a); // Boxing
        System.out.println(i);

        // Autoboxing : Automatically converting primitive data type into its corresponding wrapper class object
        Integer n = a; // autoboxing
        System.out.println(n);

        // Unboxing : Converting wrapper class object back to its primitive data type.
        int b = n.intValue(); // unboxing
        System.out.println(b);

        // Auto Unboxing : Automatically converting wrapper class object back to its primitive data type.
        int c = n; // auto unboxing
        System.out.println(c);
    }
}
