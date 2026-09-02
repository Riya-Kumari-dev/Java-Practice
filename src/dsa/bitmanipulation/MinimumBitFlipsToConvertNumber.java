package dsa.bitmanipulation;

import java.util.Scanner;

public class MinimumBitFlipsToConvertNumber {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the start number : ");
        int start = sc.nextInt();
        System.out.print("Enter the goal number : ");
        int goal = sc.nextInt();
        System.out.println("Minimum bit flips required to convert "+start+" in "+goal+" is "+minBitFlips(start, goal));
    }

    private static int minBitFlips(int start, int goal) {
        int mask = start ^ goal;
        // count the set bit in marks
        int count = 0;
        while(mask!=0){
            mask = mask & (mask-1);
            count++;
        }
        return count;
    }
}
