package multithreading;

import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private int balance = 1000;
    // ReentrantLock gives us explicit control over locking.
    private final ReentrantLock lock = new ReentrantLock();

    public void withdraw(String customer, int amount) {

        // tryLock() immediately tries to acquire the lock.
         // If another thread already holds the lock, it returns false instead of waiting indefinitely.*/
        if (lock.tryLock()) {
            try {
                System.out.println(customer + " acquired the lock.");

                // Simulate time taken to process the withdrawal.
                Thread.sleep(2000);

                if (balance >= amount) {
                    balance -= amount;
                    System.out.println(customer + " withdrew ₹" + amount);
                    System.out.println("Remaining balance: ₹" + balance);

                } else {
                    System.out.println(customer + " could not withdraw ₹" + amount + " because of insufficient balance.");
                }

            } catch (InterruptedException e) {
                // Restore the interrupted status.
                Thread.currentThread().interrupt();
                System.out.println(customer + " was interrupted.");

            } finally {
                 // unlock() must be called after successfully acquiring the lock.
                 // finally ensures that the lock is released even if an exception occurs.
                lock.unlock();
                System.out.println(customer + " released the lock.");
            }

        } else {
            // Another thread currently owns the lock.
            System.out.println(customer + " could not acquire the lock.");
        }
    }
    public int getBalance() {
        return balance;
    }
}

public class ReentrantLockDemo {
    static void main(String[] args) {
        // Both customers are accessing the same bank account.
        BankAccount account = new BankAccount();
        Thread riya = new Thread(() -> {
            account.withdraw("Riya", 600);
        });
        Thread aman = new Thread(() -> {
            account.withdraw("Rohit", 500);

        });

        // Start both withdrawal requests.
        riya.start();
        aman.start();
    }
}