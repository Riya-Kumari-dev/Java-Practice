package dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RussianDollEnvelopes {
    // envelopes[i] = [wi, hi] represents the width and the height of an envelope.
    //One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
    //Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
    //Note: You cannot rotate an envelope.
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of envelopes : ");
        int n = sc.nextInt();
        int[][] envelopes = new int[n][2];
        System.out.println("Enter the height and width of " + n + " envelopes : ");
        for(int i=0; i<n; i++){
            envelopes[i][0] = sc.nextInt();
            envelopes[i][1] = sc.nextInt();
        }
        System.out.println("Maximum number of dolls we can russian doll is "+maxEnvelopes(envelopes));
    }
    private static int maxEnvelopes(int[][] arr){
        // sort increasing but if first element same then decreasing
            Arrays.sort(arr, (a,b) -> (a[0] != b[0]) ? Integer.compare(a[0],b[0]) : Integer.compare(b[1], a[1]));
        ArrayList<Integer> ans = new ArrayList<>();
            for(int i=0; i<arr.length; i++) {
            int ele = arr[i][1];
            if(ans.size() == 0 || ans.getLast() < ele) ans.add(ele);
            else replace(ans, ele);
        }
            return ans.size();
    }
    private static int replace(ArrayList<Integer> ans, int ele){
        int lo = 0; int hi = ans.size()-1; int lb = -1;
        while(lo<=hi){
            int mid = lo + (hi - lo)/2;
            if(ans.get(mid) >= ele){
                lb = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return ans.set(lb, ele);
    }
//    public static class Envelope implements Comparable<Envelope>{
//        int w;
//        int h;
//        Envelope(int w, int h){
//            this.w = w;
//            this.h = h;
//        }
//        public int compareTo(Envelope e){
//            if(this.w == e.w) return e.h - this.h; // descending order on the basis of width
//            return this.w - e.w; // ascending order on the basis of width
//        }
//    }
//    private static int maxEnvelopes(int[][] nums) {
//        int n = nums.length;
//        Envelope[] arr = new Envelope[n];
//        for(int i=0; i<n; i++){
//            arr[i] = new Envelope(nums[i][0], nums[i][1]);
//        }
//        Arrays.sort(arr);
//        // LIS on nums
//        ArrayList<Integer> ans = new ArrayList<>();
//        for (Envelope envelope : arr) {
//            int ele = envelope.h;
//            if (ans.isEmpty() || ans.getLast() < ele) ans.add(ele);
//            else replace(ans, ele);
//        }
//        return ans.size();
//    }
//    private static int replace(ArrayList<Integer> ans, int ele){
//        int lo = 0; int hi = ans.size()-1; int lb = -1;
//        while(lo<=hi){
//            int mid = lo + (hi - lo)/2;
//            if(ans.get(mid) >= ele){
//                lb = mid;
//                hi = mid-1;
//            }
//            else lo = mid+1;
//        }
//        return ans.set(lb, ele);
//    }
}
