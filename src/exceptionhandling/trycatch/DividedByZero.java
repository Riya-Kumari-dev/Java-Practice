package exceptionhandling.trycatch;

import java.util.Scanner;

public class DividedByZero {
    static void main(String[] args) {
        System.out.println("Connection Established");
        Scanner sc = new Scanner(System.in);
        // if exception is handled normal termination if not the matter will go to default exception handler by runtime system of jvm
        try{
            System.out.println("Enter the numerator : ");
            int num = sc.nextInt();
            System.out.println("Enter the denominator : ");
            int den = sc.nextInt();
            int res = num/den;
            System.out.println(num+" divided by "+den+" is "+res);
        }
        catch(ArithmeticException e){ // ✅
            System.out.println("Kindly enter a non zero number");
        }
        /*catch(Exception e){ ✅
            System.out.println("Kindly enter a non zero number");
        }*/
        System.out.println("Connection Terminated");
    }
}
