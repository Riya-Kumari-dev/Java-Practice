package dsa.binarysearch;

import java.util.Scanner;

public class KokoEatingBananas {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of piles : ");
        int n = sc.nextInt();
        int[] piles = new int[n];
        System.out.print("Enter quantities of bananas for "+n+" number of piles : ");
        for(int i=0; i<n; i++){
            piles[i] = sc.nextInt();
        }
        System.out.print("Enter the maximum number of hours : ");
        int hours = sc.nextInt();
        System.out.println("Minimum eating speed is "+minEatingSpeed(piles, hours));
    }

    private static int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        int lo = 1;
        int hi = max;
        int ans = max;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(hours(piles, mid) <= h){
                ans = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return ans;
    }
    private static int hours(int[] arr, int speed){
        int h = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] % speed == 0) h += arr[i]/speed;
            else h += arr[i]/speed + 1;
//            int x = arr[i];
//            while(x > 0){
//                if(s < x ) x -= s;
//                else x = 0;
//                h++;
//            }
        }
        return h;
    }
}