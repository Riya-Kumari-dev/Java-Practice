package dsa.strings.String;

public class Trim {
    static void main(String[] args) {
        String s = "  Raja Ram Mohan Roy  ";
        System.out.println(s.trim()); // removes leading and trailing spaces
        System.out.println(s.stripLeading()); // removes leading spaces
        System.out.println(s.stripTrailing()); // removes trailing spaces
    }
}
