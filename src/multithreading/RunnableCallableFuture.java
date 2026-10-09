package multithreading;

import java.util.concurrent.*;

class EmailTask implements Runnable {

    @Override
    public void run() {
        // Runnable performs a task without returning a result.
        System.out.println("Order confirmation email sent by " + Thread.currentThread().getName());
    }
}

class BillCalculator implements Callable<Integer> {

    private final int price;
    private final int quantity;

    public BillCalculator(int price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public Integer call() throws Exception {
        // Callable can return a result.
        int total = price * quantity;
        System.out.println("Bill calculated by "+ Thread.currentThread().getName());
        return total;
    }
}

public class RunnableCallableFuture {
    static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Runnable: submit a task that doesn't return a result.
        executor.execute(new EmailTask());

        // Callable: submit a task that calculates the bill.
        Callable<Integer> billTask = new BillCalculator(500, 3);

        // submit() returns a Future representing the pending result.
        Future<Integer> billFuture = executor.submit(billTask);

        System.out.println("Other work can continue here...");

        // get() waits if necessary until the result is available.
        // It returns the value produced by Callable.call().
        int totalBill = billFuture.get();

        System.out.println("Total bill: Rs " + totalBill);

        // Stop accepting new tasks.
        executor.shutdown();
    }
}