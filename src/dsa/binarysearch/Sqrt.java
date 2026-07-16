package dsa.binarysearch;

import java.util.Scanner;

public class Sqrt {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer : ");
        int n = sc.nextInt();

        System.out.println("Square root of "+n+" is "+sqrt(n));
    }

    private static int sqrt(int n) {
        long lo = 0;
        long hi = n;
        while(lo <= hi){
            long mid = lo + (hi-lo)/2;
            long sq = mid*mid;
            if(sq == n) return (int)mid;
            else if(sq > n) hi = mid-1;
            else lo = mid+1;
        }
        return (int)hi; // hi will be the round off integer of sqrt(n) if it is non-integer.
    }
}