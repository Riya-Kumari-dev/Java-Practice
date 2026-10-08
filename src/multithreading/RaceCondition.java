package multithreading;

public class RaceCondition {
    // A race condition occurs when multiple threads access shared mutable data and
    // the result depends on the timing/interleaving of their operations.

    static int count = 0;
    static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                count++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                count++;
            }
        });

        // Both threads access and modify the same shared variable.
        t1.start();
        t2.start();

        // Wait for both threads to finish.
        t1.join();
        t2.join();

        System.out.println("Final count: " + count); // not predictable
        // count++ is not atomic.
        //So with two threads doing 1000 increments each, the expected result is 2000, but the actual result may be less than 2000.
    }
}