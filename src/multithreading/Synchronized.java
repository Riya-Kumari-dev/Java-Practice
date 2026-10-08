package multithreading;

public class Synchronized {
    static int count = 0;

    // Only one thread at a time can execute this synchronized method for the same object.
    static synchronized void increment() {
        count++;
    }

    static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        });

        // Both threads start and access the same shared count through increment().
        t1.start();
        t2.start();

        // Wait for both threads to complete.
        t1.join();
        t2.join();

        // Because both threads use the same class lock, they cannot execute the critical section simultaneously.

        // Now both threads have completed their work.
        System.out.println("Final count: " + count); //the result is now reliably 2000.
    }
}