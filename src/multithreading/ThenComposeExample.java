package multithreading;

import java.util.concurrent.CompletableFuture;

public class ThenComposeExample {
    // Simulates fetching customer details asynchronously.
    static CompletableFuture<String> getCustomerName(int customerId) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching customer details...");
            // Return the customer's name.
            return "Riya";
        });
    }

    // Simulates fetching order history using the customer's name.
    static CompletableFuture<String> getOrderHistory(String customerName) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching order history for " + customerName + "...");
            // Return the customer's order history.
            return "Laptop, Headphones";
        });
    }

    static void main(String[] args) {
        // Step 1: Fetch customer details asynchronously.
        CompletableFuture<String> orderHistoryFuture = getCustomerName(101)
                // Step 2: Once the customer name is available, start another asynchronous task to fetch that customer's order history.
                .thenCompose(name -> getOrderHistory(name)
                );

        // Step 3: Wait for the final result and display it.
        System.out.println("Order history: " + orderHistoryFuture.join());
    }
}