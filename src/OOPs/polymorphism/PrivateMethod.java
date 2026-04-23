package OOPs.polymorphism;

class Bank{
    private void calculateInterest(){
        System.out.println("Interest Calculated");
    }
}
class SBI extends Bank{
    void calculateInterest(){ // No overriding, just a new method
        System.out.println("SBI interest");
    }
}
public class PrivateMethod {
    static void main(String[] args) {
        Bank b = new SBI();
        // b.calculateInterest(); // cannot access

        SBI c = new SBI();
        c.calculateInterest(); // SBI interest => can access because it acts like specialized method of the child class

        // downcasting

        SBI s = (SBI)b;
//        if(b instanceof SBI) {  // safe downcasting
//            SBI s = (SBI)b;
//        }
        s.calculateInterest(); // SBI interest => now can access
    }
}
