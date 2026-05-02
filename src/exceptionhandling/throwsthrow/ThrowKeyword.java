package exceptionhandling.throwsthrow;

import java.util.Scanner;

class Alpha2{
    // if we have handled then why throw ❓
    // sometimes the matter should go the master also
    // throwing handled exception is rethrowing exception
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
            throw e; // it is like return statement after that no statement will execute apart from finally block
            // throw => to handover the exception object to JVM manually
        }
        System.out.println("Alpha connection terminated"); // if exception occured and handled by catch block then because throw , this statement will not execute
    }
}

public class ThrowKeyword {
    static void main(String[] args) {
        System.out.println("Main connection established");
        try{
            Alpha2 a = new Alpha2();
            a.calc();
        }
        catch(ArithmeticException e){
            System.out.println("some problem");
            System.out.println("Handled in main");
        }
        System.out.println("Main connection terminated");
    }
}
