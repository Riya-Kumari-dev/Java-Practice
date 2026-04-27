package lambdaexpression;

// functional interface => only one method as abstract
interface Person{
    void speak();
    String toString(); // allowed // not counted as abstract method
}
interface Calc{
    int add(int a, int b);
}
public class LambdaExpression {
    static void main(String[] args) {
        // lambda expression wants only one abstract method
        Person p = () -> System.out.println("hello");
        p.speak();

//        Calc c = (x, y) -> {
//            return x+y;
//        };
        int z = 20; // should be final or effectively final to be used in lambda expression
        Calc c = (x, y) -> x+y+z;
        System.out.println(c.add(3,4));
        // z = 10; // not allowed
    }
}
