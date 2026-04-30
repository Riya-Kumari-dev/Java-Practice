package dsa.strings.String;

public class MemoryMap {
    static void main(String[] args) {
        // Declaring using direct literals get located in string constant pool
        String s1 = "Riya";  // s1-> "Riya"
        String s2 = "Riya"; // s1 and s2 both are referring to same object "Riya" in string constant pool
        System.out.println(s1 == s2); // true // == compares the address of the objects

        // Declaring using new keyword get located in general heap area and scp also but the reference variable will be pointing to general heap area object
        String str1 = new String("Riya"); // str1 -> "Riya"
        String str2 = new String("Riya"); // str2 -> "Riya"
        System.out.println(str1 == str2); // false

        System.out.println(s1==str1); // false => s1 in string constant pool and str1 is on general heap area
    }
}
