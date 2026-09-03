package dsa.bitmanipulation;

import java.util.Scanner;

public class XorOfNumbersInGivenRange {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the starting range : ");
        int start = sc.nextInt();
        System.out.print("Enter the ending range : ");
        int end = sc.nextInt();
        System.out.println("Xor of numbers between "+start+" and "+end+" is "+findXor(start, end));
    }

    private static int findXor(int start, int end) {
        return xor(start-1)^xor(end);
    }
    private static int xor(int n){
        if(n%4 == 0) return n;
        if(n%4 == 1) return 1;
        if(n%4 == 2) return n+1;
        else return 0;
    }
}