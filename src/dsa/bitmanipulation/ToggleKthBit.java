package dsa.bitmanipulation;

import java.util.Scanner;

public class ToggleKthBit {
    static void main(String[] args) {
        // toggle kth bit means reverse the kth bit
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        System.out.print("Enter k : ");
        int k = sc.nextInt();
        n = toggleKthBit(n, k);
        System.out.println(n);
    }

    private static int toggleKthBit(int n, int k) {
        return (n ^ (1 << k));
    }
}