package dsa.recursion;

import java.util.Scanner;

public class GCD {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a : ");
        int a = sc.nextInt();
        System.out.print("Enter b : ");
        int b = sc.nextInt();
        //System.out.println("GCD of "+a+", "+b+" is "+hcf(a,b));
        System.out.println("GCD of "+a+", "+b+" is "+gcd(a,b));
    }
    // TC = O(log(min(a,b)))
    private static int gcd(int a, int b){
        if(b == 0) return a;
        return hcf(b,a%b);
    }
    private static int hcf(int a, int b){
        for(int i=Math.min(a,b); i>=1; i--){ // TC = O(min(a,b))
            if(a%i == 0 && b%i ==0){
                return i;
            }
        }
       return -1;
    }
}
