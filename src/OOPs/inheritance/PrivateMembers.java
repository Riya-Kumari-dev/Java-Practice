package OOPs.inheritance;
class Parent2{
    private int age = 67;
    private void show(){
        System.out.println("Private method");
    }
}
class Child3 extends Parent2{
    void display(){
//        System.out.println(age); ❌ error (not inherited)
//        System.out.println(show()); ❌ error
    }
}
public class PrivateMembers {
    static void main(String[] args) {
        Child3 c = new Child3();
        c.display();
    }

}
