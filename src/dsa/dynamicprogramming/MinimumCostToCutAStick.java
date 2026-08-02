package dsa.dynamicprogramming;

import java.util.Arrays;

public class MinimumCostToCutAStick {
    // Given a wooden stick of length n units. The stick is labelled from 0 to n. For example, a stick of length 6 is labelled as follows:
    //Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.
    //You should perform the cuts in order, you can change the order of the cuts as you wish.
    //The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts. When you cut a stick, it will be split into two smaller sticks (i.e. the sum of their lengths is the length of the stick before the cut). Please refer to the first example for a better explanation.
    //Return the minimum total cost of the cuts.
    static void main(String[] args){
        int n = 7;
        int[] arr = {1,3,4,5};
        System.out.println("Minimum cost to cut the given stick is "+minCost(n,arr));
    }
    private static int minCost(int n, int[] cuts){
        int[] cuts2 = new int[cuts.length+2];
        int i;
        for(i=0; i<cuts.length; i++){
            cuts2[i] = cuts[i];
        }
        cuts2[i++] = 0;
        cuts2[i] = n;
        Arrays.sort(cuts2);
        int m = cuts2.length;
        int[][] dp = new int[m-1][m-1];
        return cost(1, cuts2.length-2, cuts2, dp);
    }
    private static int cost(int i, int j, int[] arr, int[][] dp){
        if(i>j) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k=i; k<=j; k++){
            int len = arr[j+1] - arr[i-1];
            int totalCost = cost(i,k-1, arr, dp) + cost(k+1, j, arr, dp) + len;
            min = Math.min(min, totalCost);
        }
        return dp[i][j] = min;
    }
}
