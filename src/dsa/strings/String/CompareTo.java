package dsa.strings.String;

public class CompareTo {
    static void main(String[] args) {
        String s1 = "Suresh";
        String s2 = "Sunita";
        // equals() => overridden method
        // equals compare the data and return type is boolean
        System.out.println(s1.equals(s2)); // false

        // compareTo => checks character by character
        // compares the first coming differences in s1 and s2 => r and n
        // result type is integer
        // if res == 0 => both strings are equal
        // if res > 0 => s1.compareTo(s2) => s1 > s2
        // if res < 0 => s2 > 1
        int res = s1.compareTo(s2);
        System.out.println(res); // r -n => 114 - 110 => 4
        if(res == 0){
            System.out.println("Strings are equal");
        }
        else System.out.println("Strings are not equal");
    }
}
