package dsa.bitmanipulation;

import java.util.Scanner;

public class PowerOfFour {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        if(isPowerOfFour(n)) System.out.println("Yes, " + n + " is a power of four.");
        else System.out.println("No, "+n+" is not a power of four.");

    }

    private static boolean isPowerOfFour(int n) {
        if(n<=0) return false;
        // 4 ^ k = 2^2^k = 2 ^k^2
        // it should be a power of two for sure,and any power of four leaves a remainder 1 when divided by 3.
        return ((n & (n-1))== 0 && n%3 ==1);
    }

//    private static boolean isPowerOfFour(int n) {
//        if(n<=0) return false;
//        // 4 ^ k = 2^2^k = 2 ^k^2
//        // it should be a power of two for sure,and a perfect square.
//        return ((n & (n-1))== 0 && isPerfectSquare(n));
//    }
//
//    private static boolean isPerfectSquare(int n){
//        int sqrt = (int)(Math.sqrt(n));
//        return (sqrt*sqrt == n);
//    }

    //TC = O(log(n))
//    private static boolean isPowerOfFour(int n) {
//        if(n==1) return true;
//        if(n <= 0 || n% 4 != 0) return false;
//        return isPowerOfFour(n/4);
//    }
}
