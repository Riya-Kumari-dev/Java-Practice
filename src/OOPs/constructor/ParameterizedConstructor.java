package OOPs.constructor;

class Student1{
    int age;
    String name;
    // Since we add a constructor now the compiler will not add any default constructor
    Student1(int a, String n){  //  Parameterized constructor -> constructor accepts parameters
        // values are provided during object creation
        age = a;
        name = n;
    }
}
public class ParameterizedConstructor {
    static void main(String[] args) {
        Student1 s = new Student1(20, "Riya");
        System.out.println(s.age);
        System.out.println(s.name);
    }
}
