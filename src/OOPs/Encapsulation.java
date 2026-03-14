package OOPs;

class Account{
    // Encapsulation :
    // - Process of providing security to most important component of object (data member) by making it private and giving controlled access through getter and setters.
    private double balance; // a bank account balance should have a controlled access
    public void credit(double amount){
        if(amount > 0) balance += amount;
    }
    public void debit(double amount){
        if(amount <= balance) balance -= amount;
        else System.out.println("Insufficient balance.");
    }

    // the above two are setters
    public double getBalance(){ // getter
        return balance;
    }
}
public class Encapsulation {
    public static void main(String[] args){
        Account riya = new Account();
        riya.credit(3000.0);
        riya.debit(1000);
        System.out.println(riya.getBalance());
    }
}

