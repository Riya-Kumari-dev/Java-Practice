package OOPs.inheritance;

class Parent{
    int age = 56;
    int property = 900;

}
// Multilevel inheritance
class Child extends Parent{
    String name = "Ritvik";


}
class Child2 extends Parent{
    String name = "Aditi";

}
// Java doesn't support multiple inheritance
//class Grandchild extends Child, Child2{
//
//}
// Java does not support cyclic inheritance
//class Parent2 extends Child3{
//
//}
//class Child3 extends Parent2{
//
//}

public class InheritanceType {
    static void main(String[] args) {
        Child c = new Child();
        System.out.println(c.name + "   "+c.property);
        Child2 c2 = new Child2();
        System.out.println(c2.name+"   "+c.property);
    }
}
