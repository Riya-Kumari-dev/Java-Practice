package dsa.dynamicprogramming;

import java.util.Scanner;

public class UniqueBinarySearchTrees {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of nodes : ");
        int n = sc.nextInt();
        System.out.println("Number of structurally unique BST's which has exactly "+n+" nodes of unique values from 1 to "+n+" is "+numTrees(n));
    }
    private static int numTrees(int n) {
        if(n<=1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=1; j<=i; j++){
                int left = j-1;
                int right = i-j;
                dp[i] +=  dp[left] * dp[right];
            }
        }
        return dp[n];
    }
}
