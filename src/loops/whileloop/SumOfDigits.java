package loops.whileloop;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        int orig = n;
        int sum = 0;
        while(n!=0){
            sum+=(n%10);
            n/=10;
        }
        System.out.println("Sum of all the digits of "+orig+" is "+(sum>0 ? sum : -sum));
    }
}
