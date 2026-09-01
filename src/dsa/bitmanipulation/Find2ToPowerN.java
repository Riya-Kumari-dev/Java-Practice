package dsa.bitmanipulation;

import java.util.Scanner;

public class Find2ToPowerN {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        System.out.println("2 to the power "+n+" is "+ (1<<n));
    }
}