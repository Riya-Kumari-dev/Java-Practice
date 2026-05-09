package dsa.recursion;

import java.util.Scanner;

public class Fibonacci {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        System.out.println(n + "th fibonacci is " + fibo(n));
    }
    private static int fibo(int n) {
        if(n==1 || n==2) return 1;
        return fibo(n-1)+fibo(n-2);
    }
}