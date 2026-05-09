package dsa.recursion;

import java.util.Scanner;

public class Power {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the base : ");
        int a = sc.nextInt();
        System.out.print("Enter the exponent : ");
        int b = sc.nextInt();
        if(a==0 && b==0) {
            System.out.println("Not defined");
        }
        else System.out.println(a+" raised to power "+b+" is "+power(a,b));
    }
    private static int power(int a, int b){
        if(b == 0 || a==1) return 1;
        if(b==1) return a;
        int pow = power(a, b/2);
        if(b%2 == 0) return pow*pow;
        return pow*pow*a;
    }
}