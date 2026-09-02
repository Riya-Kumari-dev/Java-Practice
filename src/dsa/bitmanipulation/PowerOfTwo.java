package dsa.bitmanipulation;

import java.util.Scanner;

public class PowerOfTwo {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        if(isPowerOfTwo(n)) System.out.println("Yes, " + n + " is a power of two.");
        else System.out.println("No, "+n+" is not a power of two.");

    }

    private static boolean isPowerOfTwo(int n) {
        return (n<=0 ? false : (n & (n-1)) == 0);
    }

    // TC = O(log(n))
//    private static boolean isPowerOfTwo(int n) {
//        if(n==1) return true;
//        if(n <= 0 || n% 2 != 0) return false;
//        return isPowerOfTwo(n/2);
//    }

}
