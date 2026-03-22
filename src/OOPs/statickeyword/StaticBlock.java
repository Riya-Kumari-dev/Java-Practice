package OOPs.statickeyword;
class Human{
    int age;
    String name;
    static int leg = 2;
    static int hand = 2;
    // Execute only once
    // Runs when class is Loaded
    static{
        System.out.println("Static Block");
    }
    Human(){
        System.out.println("Default Constructor");
    }
    Human(int age, String name){
        System.out.println("Parameterized Constructor");
        this.age = age;
        this.name = name;
    }
    void display(){
        System.out.println("Name  : "+name);
        System.out.println("Age : "+age);
        System.out.println("Hand : "+hand);
        System.out.println("Legs : "+leg);
        System.out.println();
    }
}
public class StaticBlock {
    // runs before main method
    static{
        System.out.println("static block before main method");
    }
    static void main(String[] args) {
        System.out.println("Main method");
//        Human h = new Human();
//        h.age = 23;
//        h.name = "Riya";
        //h.display();
        Human h2 = new Human(24, "Aditi");
        h2.display();

    }
}
