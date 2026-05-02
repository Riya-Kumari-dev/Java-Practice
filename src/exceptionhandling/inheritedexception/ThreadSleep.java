package exceptionhandling.inheritedexception;

public class ThreadSleep {
    // Throwable is Grandmaster of all the exception.
    // There are two types of Exception mainly checked and unchecked
    // All the exceptions occur at runtime only.
    // checked Exception : Such exception which possibilities are checked by the compiler
    // unchecked exception : not checked at compile time
    // Exception is partially checked exception
    static void main(String[] args) throws InterruptedException {
        System.out.println("Main method initiated");
        Thread.sleep(5000); // sleep for 5 sec // checked exception
        System.out.println("Main method terminated");
    }
}
