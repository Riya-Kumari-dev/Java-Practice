package dsa.collections.queue;

import java.util.*;

public class FirstNegativeInEveryWindowOfSizeK {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the size of the window : ");
        int k = sc.nextInt();
        ArrayList<Integer> ans = firstNegInt(arr, k);
        System.out.println(Arrays.toString(arr));
        System.out.println(ans);
    }

    private static ArrayList<Integer> firstNegInt(int[] arr, int k) {
        Queue<Integer> q = new LinkedList<>();
        int n = arr.length;
        // store the index of the negative elements in queue
        for(int i=0; i<n; i++){
            if(arr[i]<0) q.add(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<n-k+1; i++){
            // index chhota hai current q.peek() se  mean hamara window aage hai
            while(!q.isEmpty() && q.peek()<i) q.remove();
            if(!q.isEmpty() && q.peek()<=i+k-1) ans.add(arr[q.peek()]); // q.peek() element lies in the current window so add it to the ans
            else ans.add(0); // mean current window me koi negative element hai hi nhi
        }
        return ans;
    }
}
