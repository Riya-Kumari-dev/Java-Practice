package dsa.bitmanipulation;

import java.util.Scanner;

public class SetKthBit {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        System.out.print("Enter k : ");
        int k = sc.nextInt();
        n = setKthBit(n, k);
        System.out.println(n);
    }

    private static int setKthBit(int n, int k) {
        return (n | (1 << k));
    }
}