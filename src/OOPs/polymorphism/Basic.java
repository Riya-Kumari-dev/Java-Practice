package OOPs.polymorphism;
class Payment{
    void pay(){
        System.out.println("Processing payment");
    }
}
class UPI extends Payment {
    void pay(){
        System.out.println("Paying using UPI");
    }
}
class Card extends Payment {
    void pay(){
        System.out.println("Paying using Card");
    }
}
public class Basic {
    static void main(String[] args) {
        Payment p = new UPI(); // Parent type reference
        p.pay(); // Paying using UPI

        p = new Card();
        p.pay(); // Paying using Card
        // same action different behaviour
    }
}
