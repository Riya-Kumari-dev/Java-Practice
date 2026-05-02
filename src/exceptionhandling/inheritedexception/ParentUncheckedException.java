package exceptionhandling.inheritedexception;

import java.io.IOException;

class Parent1{
    public void work()throws ArithmeticException{
        System.out.println("Parent works hard");
    }
}
class Child12 extends Parent1{ // can have no exception
    public void work(){
        System.out.println("Child also works hard");
    }
}
class Child13 extends Parent1{
    // can throw unchecked exception while overriding
    public void work()throws ArithmeticException{
        System.out.println("Child2 also works hard");
    }
}
//class Child14 extends Parent1{
//    // cannot throw unchecked exception while overriding
//    public void work()throws IOException {
//        System.out.println("Child2 also works hard");
//    }
//}
public class ParentUncheckedException {
    static void main(String[] args) {
        Child12 c = new Child12();
        c.work();
        Child13 c2 = new Child13();
        c2.work();
    }
}
