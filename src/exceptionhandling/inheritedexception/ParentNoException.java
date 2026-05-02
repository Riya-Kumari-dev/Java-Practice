package exceptionhandling.inheritedexception;

class Parent{
    public void work(){
        System.out.println("Parent works hard");
    }
}
class Child extends Parent{ // can have no exception
    public void work(){
        System.out.println("Child also works hard");
    }
}
class Child2 extends Parent{
    // can have unchecked exception
    public void work()throws ArithmeticException{
        System.out.println("Child2 also works hard");
    }
}
//class Child3 extends Parent{
//    // cannot have unchecked exception
//    public void work()throws IOException {
//        System.out.println("Child3 also works hard");
//    }
//}

public class ParentNoException {
    static void main(String[] args) {
        Child c = new Child();
        c.work();
        Child2 c2 = new Child2();
        c2.work();
    }
}
