package dsa.strings.mutablestring;

public class StringBuffers {
    static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity()); // 16 initial capacity
        sb.append("Riya Gupta");
        System.out.println(sb.capacity()); // 16
        sb.append("Dharamshala");
        System.out.println(sb.capacity()); // 34 => new capacity = old capacity * 2 + 2

        // waste of space right
        sb.trimToSize();
        System.out.println(sb.capacity()); // 21

        StringBuffer sb2 = new StringBuffer("Riya");
        System.out.println(sb2.capacity()); // 16 + sb2.length() => 16 + 4 => 20
        sb2.append("Aditi Dahiya     ");
        System.out.println(sb2.capacity()); // 20*2+2 => 42
    }
}
