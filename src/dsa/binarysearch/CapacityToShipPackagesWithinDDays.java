package dsa.binarysearch;

import java.util.Scanner;

public class CapacityToShipPackagesWithinDDays {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of packages : ");
        int n = sc.nextInt();
        int[] weights = new int[n];
        System.out.print("Enter weights of "+n+" packages : ");
        for(int i=0; i<n; i++){
            weights[i] = sc.nextInt();
        }
        System.out.print("Enter the maximum number of days : ");
        int days = sc.nextInt();
        System.out.println("Least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within "+days+" days : "+shipWithinDays(weights, days));
    }

    // The ith package on the conveyor belt has a weight of weights[i].
    // Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
    // We may not load more weight than the maximum weight capacity of the ship.
    private static int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int weight : weights) {
            max = Math.max(weight, max);
            sum += weight;
        }
        int lo = max; // if the capacity would be less than max then it is not possible to ship that packages, so minimum capacity should be the maximum weight
        int hi = sum; // Total weight sum should be the maximum capacity, it can be shipped in one day
        int ans = sum; // capacity
        while(lo<=hi){ // TC = (n*log(sum-max))
            int mid = lo + (hi-lo)/2;
            if(daysRequired(mid, weights) <= days){
                ans = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return ans;
    }
    private static int daysRequired(int capacity, int[] arr){
        int days = 0;
        int c = capacity;
        for (int ele : arr) {
            if (ele <= c) {
                c -= ele;
            } else {
                days++; // next day
                c = capacity - ele;
            }
        }
        days++;
        return days;
    }
}