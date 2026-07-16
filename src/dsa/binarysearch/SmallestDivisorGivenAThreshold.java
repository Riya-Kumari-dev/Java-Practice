package dsa.binarysearch;

import java.util.Scanner;

public class SmallestDivisorGivenAThreshold {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter threshold : ");
        int threshold = sc.nextInt();
        System.out.println("Smallest Divisor is "+smallestDivisor(arr,threshold));
    }

    //  we will choose a positive integer divisor, divide all the array by it, and sum the division's result.
    //  Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
    //Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

    private static int smallestDivisor(int[] arr, int threshold) {
        int mx = -1;
        for(int ele : arr) mx = Math.max(mx, ele);
        int lo =1;
        int hi = mx;
        int ans = -1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(canDivide(arr, mid) <= threshold){
                ans = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return ans;
    }

    private static int canDivide(int[] arr, int d) {
        int sum = 0;
        for (int ele : arr) {
            if (ele % d == 0) sum += ele / d;
            else sum += ele / d + 1;
        }
        return sum;
    }
}