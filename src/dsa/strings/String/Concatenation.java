package dsa.strings.String;

public class Concatenation {
    static void main(String[] args) {
        String s1 = "Riya";
        s1.concat(" Gupta"); // a new object is created in heap area but no one is referring to it
        System.out.println(s1); // String class is immutable
        s1 = s1.concat(" Gupta");
        System.out.println(s1);

        // whenever we use references , the object will be created in general heap area not the string constant pool
        String s2 = "Riya Gupta";
        System.out.println(s1 == s2); // false

        // using + we can add any number of strings
        String s3 = "Riya" + " Gupta"+" Kumari"; // in string constant pool
        String s = s2+" Kumari"; // again in normal heap area
        System.out.println(s3 == s); // false

        String s4 = "Riya " + 10 + 30+ 40;
        System.out.println(s4); // Riya 103040
        String s5 = 10+20+40+" Riya";
        System.out.println(s5);// 70 Riya
    }
}
