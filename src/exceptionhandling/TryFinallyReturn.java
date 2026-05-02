package exceptionhandling;

public class TryFinallyReturn {
    static void main(String[] args) {
        try{
            System.out.println("A");
            return;
        }
        finally{
            System.out.println("Finally block"); // ✅ will be printed
        }
    }
}
