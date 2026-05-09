package dsa.recursion;

import java.util.Scanner;

public class TowerOfHanoi {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of discs : ");
        int n = sc.nextInt();
        hanoi(n, 'A', 'B', 'C');
    }
    static void hanoi(int n, char source, char helper, char dest){
        if(n==0) return;
        // n-1 discs from A to B via C
        hanoi(n-1, source, dest, helper);
        // larget disc from A to C
        System.out.println(source+"->"+dest);
        // n-1 discs from B to C via A
        hanoi(n-1, helper, source, dest);
    }
}
