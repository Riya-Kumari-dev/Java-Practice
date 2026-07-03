package dsa.prefixsum;

import java.util.Arrays;
import java.util.Scanner;

public class LongestSubsequenceWithLimitedSum {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the size of the query : ");
        int m = sc.nextInt();
        int[] q = new int[m];
        System.out.print("Enter " + m + " elements for the query : ");
        for (int i = 0; i < m; i++) {
            q[i] = sc.nextInt();
        }

        // Return an array answer of length m
        // where answer[i] is the maximum size of a subsequence that you can take from arr
        // such that the sum of its elements is less than or equal to queries[i].

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(q));
        System.out.println("Ans : "+ Arrays.toString(answerQueries(arr, q)));
    }

    // TC = O((m+n)log(n)) , AS = O(log(n))
    private static int[] answerQueries(int[] arr, int[] q) {
        // we can get maximum size having sum <= q[i] if we have smaller elements
        int n = arr.length;
        // first sort arr so that we can get the min elements at first
        Arrays.sort(arr); // TC = O(nlog(n)) , AS = O(log(n))

        // apply prefix sum so that we can find till how many elements the sum <= q[i]
        for(int i=1; i<n; i++){ // TC = O(n)
            arr[i] += arr[i-1];
        }

        // binary search so that we can find the largest prefix sum that is less than or equal to q[i] in O(log(n))
        int[] ans = new int[q.length];
        for(int i=0; i<q.length; i++){ // TC = O(m*log(n))
            int lo = 0;
            int hi = n-1;
            while(lo <= hi){ // TC = O(log(n))
                int mid = lo+(hi-lo)/2;
                if(arr[mid] > q[i]) hi = mid-1;
                else{
                    ans[i] = Math.max(ans[i], mid+1);
                    lo = mid + 1;
                }
            }
        }
        return ans;
    }
}