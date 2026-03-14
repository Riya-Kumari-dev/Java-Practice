package OOPs.constructor;

class Student2{
    int age;
    String name;
    // Constructor overloading
    // same class has multiple constructors with different parameters
    Student2() {

    }
    Student2(int a, String n){  //  Parameterized constructor
        age = a;
        name = n;
    }
}
public class ConstructorOverloading {
    static void main(String[] args) {
        Student2 s = new Student2(20, "Riya");
        System.out.println(s.age);
        System.out.println(s.name);

        Student2 s2 = new Student2();
        s2.age = 23;
        s2.name = "Sahiba";
        System.out.println(s2.name);
        System.out.println(s2.age);
    }
}
