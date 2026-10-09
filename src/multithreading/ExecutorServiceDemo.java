package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class OrderProcessor implements Runnable {
    private final int orderId;
    public OrderProcessor(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run() {
        // Identify the worker thread processing this order.
        String threadName = Thread.currentThread().getName();

        System.out.println("Processing order " + orderId + " using " + threadName);

        // Simulate order processing.
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            // Restore the interrupted status.
            Thread.currentThread().interrupt();
            System.out.println("Order " + orderId + " was interrupted.");
            return;
        }
        System.out.println("Order " + orderId + " completed.");
    }
}

public class ExecutorServiceDemo {
    static void main(String[] args) {
        // Create a thread pool with 3 worker threads.
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit 6 order-processing tasks to the pool.
        for (int i = 1; i <= 6; i++) {
            OrderProcessor order = new OrderProcessor(i);

            executor.execute(order); // execute() submits a task to the executor for execution.
        }

        // Stop accepting new tasks.
        // Previously submitted tasks can finish normally.
        executor.shutdown();

        System.out.println("All orders have been submitted.");
    }
}