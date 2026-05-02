package exceptionhandling.throwsthrow;

import java.util.Scanner;

class Alpha{
    // 1. it will check whether the stack that creates Exception object has exception handler if yes whi se matter resolved
    // 2. else it will check whoever calls this method agar whi mila then well and good
    // 3. if not there also it will propagate down the hierarchy to search for that exception handler
    // 4. if not found then the matter will go to default exception handler
    public void calc()throws ArithmeticException{ // ducking
        // throws => to delegate the responsibility of handling the exception to the caller
        System.out.println("Alpha connection established");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numerator : ");
        int num = sc.nextInt();
        System.out.println("Enter the denominator : ");
        int den = sc.nextInt();
        int res = num/den;
        System.out.println(num+" divided by "+den+" is "+res);
        System.out.println("Alpha connection terminated");
    }
}
class Beta{
    public void disp()throws ArithmeticException{
        System.out.println("Beta connection established");
        Alpha a = new Alpha();
        a.calc();
        System.out.println("Beta connection terminated");
    }
}
public class ExceptionNotHandledInProducer {
    static void main(String[] args) {
        System.out.println("Main connection established");
        try{
            Beta b = new Beta();
            b.disp();
        }
        catch(ArithmeticException e){
            System.out.println("Please enter non zero number");
        }
        catch(Exception e){
            System.out.println("Some problem");
        }
        System.out.println("Main connection terminated");
    }
}
