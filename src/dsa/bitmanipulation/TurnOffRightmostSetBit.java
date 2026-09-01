package dsa.bitmanipulation;

import java.util.Scanner;

public class TurnOffRightmostSetBit {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        n = clearRightmostBit(n);
        System.out.println(n);
    }

    // TC = O(1)
    private static int clearRightmostBit(int n) {
        return (n & (n-1));
    }

    // TC = O(log(n))
//    private static int clearRightmostBit(int n) {
    // find k
//        int b = n;
//        int k = 0;
//        while(b % 2 != 1){
//            b = b>>1;
//            k++;
//        }
    // turn off the kth bit
//        return (n & (~(1 << k)));
//    }
}