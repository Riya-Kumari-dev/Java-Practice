package dsa.bitmanipulation;

import java.util.Scanner;

public class CheckKthBitSetOrNot {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        System.out.print("Enter k : ");
        int k = sc.nextInt();
        if(checkSet(n, k)) System.out.println(k + "th bit in " + n + " is " + 1);
        else System.out.println(k + "th bit in " + n + " is " + 0);
    }

    private static boolean checkSet(int n, int k) {
        return ((n & (1<<k)) != 0);
    }

//    private static boolean checkSet(int n, int k) {
//        int a = n >> k;
//        return (a % 2 == 1);
//    }
}