package exceptionhandling;

import java.util.Scanner;

class Alpha{
    public void calc()throws ArithmeticException{ // ducking
        System.out.println("Alpha connection established");
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the numerator : ");
            int num = sc.nextInt();
            System.out.println("Enter the denominator : ");
            int den = sc.nextInt();
            int res = num/den;
            System.out.println(num+" divided by "+den+" is "+res);
        }
        catch(ArithmeticException e){
            System.out.println("Please enter non zero number");
            System.out.println("handled in alpha2");
            throw e; // it is like return statement after that no code will execute apart from finally block
        }
        finally {
            // execute no matter what
            // 1. no exception
            // 2. exception not matched with catch block
            // 3.  exception matched with catch block
            // 4. exception did not handled
            System.out.println("Alpha connection terminated");
        }
    }
}

public class Finally {
    static void main(String[] args) {
        System.out.println("Main connection established");
        try{
            Alpha a = new Alpha();
            a.calc();
        }
        catch(ArithmeticException e){
            System.out.println("some problem");
            System.out.println("Handled in main");
        }
        System.out.println("Main connection terminated");
    }
}
