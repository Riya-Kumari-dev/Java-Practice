package OOPs.inheritance;
class Animal{
    // constructors do not participate in inheritance
    // but they are called using super()
    Animal(){
        System.out.println("Default Constructor of Animal");
    }
}
class Dog extends Animal{
    Dog(){
        // super() calls the constructor of the parent class
        // super() is present if not mentioned Java compiler add it implicitly.
        System.out.println("Default Constructor of Dog");
    }
}
public class Super {
    static void main(String[] args) {
        Dog d = new Dog();
    }
}
