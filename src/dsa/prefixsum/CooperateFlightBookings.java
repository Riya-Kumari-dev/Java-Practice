package dsa.prefixsum;

import java.util.Arrays;
import java.util.Scanner;

public class CooperateFlightBookings {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of flights : ");
        int n = sc.nextInt();

        System.out.print("Enter the number of bookings : ");
        int m = sc.nextInt();
        int[][] bookings = new int[m][3];

        System.out.println("Enter the entries : ");
        for(int i=0; i<m; i++){
            System.out.print("Enter first : ");
            bookings[i][0] = sc.nextInt();
            System.out.print("Enter last : ");
            bookings[i][1] = sc.nextInt();
            System.out.print("Enter the capacity : ");
            bookings[i][2] = sc.nextInt();
        }

        // There are n flights that are labeled from 1 to n.
        //You are given an array of flight bookings, 
        // where bookings[i] = [firsti, lasti, seatsi] represents a booking for flights firsti through lasti (inclusive) with seatsi seats reserved for each flight in the range.
        //Return an array answer of length n, where answer[i] is the total number of seats reserved for flight i.

        System.out.println(Arrays.toString(corpFlightBookings(bookings, n)));
    }

    // TC = O(m+n) using prefix sum
    private static int[] corpFlightBookings(int[][] arr, int n) {
        int[] ans = new int[n];
        for(int i=0; i<arr.length; i++){
            int first = arr[i][0];
            int last = arr[i][1];
            int seats = arr[i][2];
            ans[first-1] += seats;
            if(last < n) ans[last] -= seats; // so that it could not be added in prefix sum
        }
        for(int i=1; i<n; i++){
            ans[i] += ans[i-1];
        }
        return ans;
    }

    // TC = O(m*n) brute force
//    private static int[] corpFlightBookings(int[][] arr, int n) {
//        int[] ans = new int[n];
//        for(int i=0; i<arr.length; i++){
//            int first = arr[i][0];
//            int last = arr[i][1];
//            int seats = arr[i][2];
//            for(int j=first-1; j<last; j++){
//                ans[j] += seats;
//            }
//        }
//        return ans;
//
//    }
}