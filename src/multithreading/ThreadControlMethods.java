package multithreading;

public class ThreadControlMethods {
    static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            try {
                // sleep() pauses the CURRENTLY executing thread for the specified time.
                Thread.sleep(2000);

                System.out.println("Worker completed sleeping.");

            } catch (InterruptedException e) {
                // If the sleeping thread is interrupted, sleep() throws InterruptedException.
                System.out.println("Worker was interrupted.");
            }

            // yield() -> Gives the scheduler a hint that the current thread is willing to yield
            // It does not guarantee that another thread will run immediately.
            Thread.yield();

            System.out.println("Worker finished.");
        });

        // Start the worker thread.
        worker.start();

        // Give the worker some time to start sleeping.
        Thread.sleep(100);

        // interrupt() requests the worker thread to stop its interruptible operation.
        // Since the worker is sleeping, sleep() throws InterruptedException.
        worker.interrupt();

        // join() makes the main thread wait until the worker thread finishes.
        worker.join();

        System.out.println("Main thread finished.");
    }
}