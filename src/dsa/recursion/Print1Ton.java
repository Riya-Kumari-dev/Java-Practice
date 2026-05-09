package dsa.recursion;

import java.util.Scanner;

public class Print1Ton {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        //print(n,1);
        print(n);
    }
    static void print(int n){
        if(n==0) return;
        print(n-1);
        System.out.println(n);
    }
//    static void print(int n, int x){
//        if(x>n) return;
//        System.out.println(x);
//        print(n,x+1);
//    }
}
