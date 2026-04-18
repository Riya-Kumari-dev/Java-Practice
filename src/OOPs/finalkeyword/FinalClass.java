package OOPs.finalkeyword;

final class BankAccount{
    private int balance = 1000;
    public int getBalance(){
        return balance;
    }
}
//class HackerAccount extends BankAccount{
//    public int getBalance(){
//        return 1000000; // ❌ Fake balance
//    }
//}
// we don't want that so making BankAccount final prevents tampering.
public class FinalClass {
    static void main(String[] args) {
        BankAccount A = new BankAccount();
        System.out.println(A.getBalance());
    }
}
