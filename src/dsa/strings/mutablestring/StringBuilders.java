package dsa.strings.mutablestring;

public class StringBuilders {
    static void main(String[] args) {
        // mutable string => same object is modified
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.capacity()); // 16 initial capacity
        sb.append("Riya Gupta");
        System.out.println(sb.capacity()); // 16
        sb.append("Dharamshala");
        System.out.println(sb);
        System.out.println(sb.capacity()); // 34 => new capacity = old capacity * 2 + 2

        // waste of space right
        sb.trimToSize();
        System.out.println(sb.capacity()); // 21

        StringBuilder sb2 = new StringBuilder("Riya");
        System.out.println(sb2.capacity()); // 16 + sb2.length() => 16 + 4 => 20
        sb2.append("Aditi Dahiya     ");
        System.out.println(sb2.capacity()); // 20*2+2 => 42

        StringBuilder s2 = new StringBuilder();
        s2.append("Riya");
        StringBuilder s3 = new StringBuilder();
        s3.append("Riya");
        // equals() is an inherited method from Object class which compares the references not the content in String class it is overridden
        System.out.println(s2.equals(s3));// false
    }
}
