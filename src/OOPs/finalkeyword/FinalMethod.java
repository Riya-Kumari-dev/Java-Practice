package OOPs.finalkeyword;

class Payment{
    final void processPayment() {
        System.out.println("Payment processing logic");
    }
}
class UpiPayment extends Payment{
    // cannot override processPayment
//    void processPayment(){
//
//    }
    // core payment logic should not be changed, but class can still be extended for other features
}
public class FinalMethod {
    static void main(String[] args) {
        Payment p = new Payment();
        p.processPayment();
    }
}
