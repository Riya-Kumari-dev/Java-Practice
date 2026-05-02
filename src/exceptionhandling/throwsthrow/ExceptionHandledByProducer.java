package exceptionhandling.throwsthrow;

import java.util.Scanner;

class Alpha1{
    public void calc(){ // ducking
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
        }
        System.out.println("Alpha connection terminated");
    }
}
public class ExceptionHandledByProducer {
    static void main(String[] args) {
        Alpha1 a = new Alpha1();
        a.calc();
    }
}