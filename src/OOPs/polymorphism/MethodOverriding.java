package OOPs.polymorphism;

class Delivery{
    void deliver(){
        System.out.println("Delivering Package");
    }
}
class ExpressDelivery extends Delivery{
    void deliver(){ // overridden
        System.out.println("Fast Delivery within 1 Day");
    }

}
public class MethodOverriding {
    static void main(String[] args) {
        Delivery d = new ExpressDelivery();
        d.deliver(); // child method will call
    }
}
