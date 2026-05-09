package dsa.recursion;

import java.util.Scanner;

public class Sum1ToN {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        //addition(n,0);
        System.out.println("Total sum of integers from 1 to "+n+" is "+sum(n));
    }
    private static int sum(int n){
        if(n==0 || n==1) return n;
        return n+sum(n-1);
    }
//    private static void addition(int n, int sum) {
//        if(n==0){
//            System.out.println(sum);
//            return;
//        }
//        addition(n-1, sum+n);
//    }
}
