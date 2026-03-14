package OOPs.constructor;

class Student3{
    int age;
    String name;
    Student3() {
        this(20,"Riya"); // calls the another constructor of the same class -> this time the parameterized one
    }
    Student3(int age, String name){  //  Parameterized constructor
        this.age = age;
        this.name = name;
    }
}
public class thisConstructorCall {
    public static void main(String[] args){
        Student3 s = new Student3();
        System.out.print(s.name+"  "+s.age);
    }
}
