package dsa.bitmanipulation;

import java.util.Scanner;

public class ClearKthBit {
    static void main(String[] args) {
        // clear kth bit means off the kth bit
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        System.out.print("Enter k : ");
        int k = sc.nextInt();
        n = clearKthBit(n, k);
        System.out.println(n);
    }

    private static int clearKthBit(int n, int k) {
        return (n & (~(1 << k)));
    }
}
