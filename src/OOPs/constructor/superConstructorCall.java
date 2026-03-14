package OOPs.constructor;

class Parent{
    Parent(){
        System.out.println("Parent constructor");
    }
}
class Child extends Parent{
    Child(){
        super(); // calls the default constructor of parent class
        // if not mentioned then it is added at the very first line by default by the java compiler
        // but this() or super() does not exist together
        System.out.println("Child Constructor");
    }
}
public class superConstructorCall {
    static void main(String[] args) {
        Child c  = new Child();
        // Parent Constructor
        // Child Constructor
    }
}
