package exceptionhandling.inheritedexception;

import java.io.IOException;

class Parent2{
    public void work()throws IOException {
        System.out.println("Parent works hard");
    }
}
class Child3 extends Parent2{ // can have no exception
    public void work(){
        System.out.println("Child also works hard");
    }
}
class Child4 extends Parent2{
    // can throw unchecked exception while overriding
    public void work()throws ArithmeticException{
        System.out.println("Child2 also works hard");
    }
}
class Child5 extends Parent2{
    // can throw checked exception while overriding
    public void work()throws IOException{
        System.out.println("Child2 also works hard");
    }
}
//class Child6 extends Parent2{
//    // cannot have Exception
//    public void work()throws Exception{
//        System.out.println("Child2 also works hard");
//    }
//}
public class ParentCheckedException {
    static void main(String[] args) {
        Child3 c = new Child3();
        c.work();
        Child4 c2 = new Child4();
        c2.work();
    }
}
