package dsa.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of stalls : ");
        int n = sc.nextInt();
        int[] stalls = new int[n];
        System.out.print("Enter positions of each stalls (total "+n+" stalls) : ");
        for(int i=0; i<n; i++){
            stalls[i] = sc.nextInt();
        }
        System.out.print("Enter the number of aggressive cows : ");
        int k = sc.nextInt();
        System.out.println("Maximum minimum distance between any two cows are "+aggressiveCows(stalls, k));
    }
    // Given an integer array arr[], which denotes the positions of stalls. All the positions are distinct. There are k aggressive cows.
    //Assign the cows to the stalls such that the minimum distance between any two cows is maximized.
    private static int aggressiveCows(int[] stalls, int k) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        Arrays.sort(stalls);
        for (int stall : stalls) {
            min = Math.min(min, stall);
            max = Math.max(max, stall);
        }
        int lo = 1;
        int hi = max - min;
        int ans = 1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(minDist(stalls, mid, k)){
                ans = mid;
                lo = mid+1;
            }
            else hi = mid-1;
        }
        return ans;
    }
    // we have to maximize the minimum dist
    private static boolean minDist(int[] stalls, int dist, int cows) {
        int c = cows;
        int prev = stalls[0];
        c--;
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - prev >= dist) {
                prev = stalls[i];
                c--;
            }
        }
        return c <= 0;
    }
}