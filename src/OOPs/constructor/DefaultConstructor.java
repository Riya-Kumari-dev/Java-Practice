package OOPs.constructor;

class Student{
    // Instance variables get default values
    int age;
    String name;
    // We did not write any constructor
    // The compiler automatically creates a default constructor
}
public class DefaultConstructor {
    static void main(String[] args) {
        Student s = new Student(); // calls the default constructor
        System.out.println(s.age); // 0
        System.out.println(s.name); // null
    }
}
