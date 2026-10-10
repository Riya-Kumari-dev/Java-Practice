package multithreading;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        // 1. supplyAsync(): Calculate the product bill asynchronously.
        CompletableFuture<Integer> billFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculating product bill...");
            int price = 1000;
            int quantity = 2;
            return price * quantity;
        });

        // 2. thenApply(): Apply a 10% discount to the bill.
        CompletableFuture<Integer> discountedBill = billFuture.thenApply(bill -> {
            System.out.println("Applying discount...");
            return bill - (bill * 10 / 100);
        });

        // 3. thenAccept(): Consume and display the discounted bill.
        // join() waits for the previous stages to complete.
        discountedBill.thenAccept( bill -> System.out.println( "Discounted bill : Rs. " + bill ) ).join();

        // 4. thenCombine(): Combine two independent calculations.
        CompletableFuture<Integer> productPrice = CompletableFuture.supplyAsync(() -> 1500);
        CompletableFuture<Integer> deliveryCharge = CompletableFuture.supplyAsync(() -> 100);
        CompletableFuture<Integer> totalAmount = productPrice.thenCombine( deliveryCharge, (price, delivery) ->  price + delivery);
        System.out.println( "Total amount including delivery charge : Rs. " + totalAmount.join() );

        // 5. exceptionally(): Handle a failed calculation and provide a fallback result.
        CompletableFuture<Integer> safeCalculation = CompletableFuture.supplyAsync(() -> {
            int number = 10;
            return number / 0; // This causes an ArithmeticException.
        }).exceptionally(exception -> {
            System.out.println( "Calculation failed using fallback value." );
            return 0;
        });
        System.out.println( "Calculation result: " + safeCalculation.join() );
    }
}