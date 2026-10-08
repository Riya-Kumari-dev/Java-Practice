package multithreading;

public class DaemonThread {
    static void main(String[] args) {
        Thread daemon = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread is running...");
            }
        });
        // Mark the thread as a daemon thread.
        // This MUST be done before start().
        daemon.setDaemon(true);

        // Check whether this thread is a daemon.
        System.out.println("Is daemon? " + daemon.isDaemon());

        // Start the daemon thread.
        daemon.start();

        // main thread finishes here.
        System.out.println("Main thread finished.");
    }
}