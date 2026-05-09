package dsa.recursion;

import java.util.Scanner;

public class UniquePaths {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows  : ");
        int n = sc.nextInt();
        System.out.print("Enter the number of columns : ");
        int m = sc.nextInt();
        System.out.println("Number of ways to go from (0,0) to ("+(n-1)+","+(m-1)+") in grid are "+ways(n, m));
    }
    static int ways(int n, int m){
        if(n==1 || m==1) return 1;
        return ways(n-1, m) + ways(n, m-1);
    }
}
