package lambdaexpression;

interface Demo{
    void show();
    default void display(){
        System.out.println("Default Method");
    }
    static void test(){
        System.out.println("Static method");
    }
}
interface Person2{
    void walk();
    void eat();
}
public class DefaultStaticMethods {
    static void main(String[] args) {
        Demo d = () -> System.out.println("Lambda works"); // works because only show() is abstract no ambiguity

        d.show();
        d.display();
        Demo.test();

        // Person2 obj2 = () -> System.out.println("Eats Banana"); // ❌ ambiguity which method to map
    }
}
