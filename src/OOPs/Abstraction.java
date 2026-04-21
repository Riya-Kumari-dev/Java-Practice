package OOPs;

// Payment System
abstract class Payment{
    abstract void pay(int amount); // must be overridden by child class
    void receipt(){
        System.out.println("Payment done. Receipt generated.");
    }
}
class UPI extends Payment{
    void pay(int amount){
        System.out.println("Paid "+amount+" using UPI");
    }
}
class CreditCard extends Payment{
    void pay(int amount){
        System.out.println("Paid "+amount+" using Credit Card");
    }
}
public class Abstraction {
    static void main(String[] args) {
        Payment p = new UPI();
        p.pay(1000);
        p.receipt();
    }
}
