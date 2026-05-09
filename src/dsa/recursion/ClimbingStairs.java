package dsa.recursion;

import java.util.Scanner;

public class ClimbingStairs {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of stairs : ");
        int n = sc.nextInt();
        System.out.println("Number of ways to reach "+n+"th stair is "+ways(n));
    }
    // can take 1 or 2 jumps
    private static int ways(int n){
        if(n==1 || n==2) return n;
        return ways(n-2)+ways(n-1);
    }
}