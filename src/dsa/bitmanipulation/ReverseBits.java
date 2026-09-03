package dsa.bitmanipulation;

import java.util.Scanner;

public class ReverseBits {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = sc.nextInt();
        System.out.println("On reversing the bits of "+n+", we get "+reverseBits(n));
    }

    // TC = O(32), AS = O(1)
    private static int reverseBits(int n) {
        int i=0;
        int j=31;
        while(i<j){
            int iMask = (1<<i);
            int jMask = (1<<j);
            // check the bit is on or off
            boolean iOn = (n&iMask) != 0;
            boolean jOn = (n&jMask) != 0;

            if(iOn != jOn){ // flip the bit
                n ^= iMask;
                n ^= jMask;
            }
            i++;
            j--;
        }
        return n;
    }
}
