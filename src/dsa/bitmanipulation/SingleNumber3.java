package dsa.bitmanipulation;

import java.util.Arrays;
import java.util.Scanner;

public class SingleNumber3 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the given array : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("The numbers in "+ Arrays.toString(arr)+" which appear only once is "+singleNumber(arr));
    }

    // TC = O(n), SC = O(1)
    private static int[] singleNumber(int[] arr) {
        int xor = 0;
        for (int ele : arr) {
            xor ^= ele;
        }
        int rightBitOff = xor & xor -1;
        int mask = rightBitOff^ xor;
        int b1 = 0;
        int b2 = 0;
        for (int ele : arr) {
            if ((mask & ele) == 0) b2 ^= ele;
            else b1 ^= ele;
        }
        return new int[]{b1, b2};

    }

    // Tc = O(n), SC = O(1);
//    private static int[] singleNumber(int[] arr) {
//        int[] ans = new int[2];
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(int ele : arr) {
//            map.put(ele, map.getOrDefault(ele, 0)+1);
//        }
//        int i=0;
//        for(int key : map.keySet()){
//            if(map.get(key) ==1) ans[i++] = key;
//        }
//        return ans;
//    }
}