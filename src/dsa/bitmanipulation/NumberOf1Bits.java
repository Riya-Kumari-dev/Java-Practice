package dsa.bitmanipulation;

import java.util.Scanner;

public class NumberOf1Bits {
    // the number of set bits in its binary representation (also known as the Hamming weight).
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();

        System.out.println("Number of set bits in "+n+" is "+hammingWeight(n));
    }

    // TC = O(count)
    private static int hammingWeight(int n) {
        // turn off the rightmost bit till the number itself become zero
        int count = 0;
        while(n!=0){
            n = n & (n-1);
            count++;
        }
        return count;
    }

    // TC = O(32)
//    private static int hammingWeight(int n) {
//        int count = 0;
//        int mask = 1;
//        for(int i=0; i<31; i++){
//            mask = (1 << i);
//            if((n & mask) != 0) count++;
//        }
//        return count;
//    }

}
