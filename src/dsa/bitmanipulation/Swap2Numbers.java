package dsa.bitmanipulation;

import java.util.Scanner;

public class Swap2Numbers {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number : ");
        int a = sc.nextInt();
        System.out.print("Enter second number : ");
        int b = sc.nextInt();
        System.out.println("a = "+a+", b = "+b);

        // method - 1
        /*int temp = a;
        a = b;
        b = temp;*/

        // method - 2
        /*a = a+b;
        b = a-b;
        a = a-b;*/

        // method - 3
        a = a^b;
        b = a^b; // b = (a^b) ^ b => b = a ^ 0 => b = a
        a = a^b; // a = (a^b) ^ a => a = 0 ^ b => a = b
        System.out.println("a = "+a+", b = "+b);
    }
}