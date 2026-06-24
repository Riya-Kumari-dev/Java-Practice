package dsa.collections.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CountNicePairsInArray {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the given array : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("There are total of "+countNicePairs(arr)+" nice pairs in "+ Arrays.toString(arr));
    }


    // A pair of indices (i, j) is nice if it satisfies all the following conditions:
    //0 <= i < j < arr.length
    //arr[i] + rev(arr[j]) == arr[j] + rev(arr[i])
    //Return the number of nice pairs of indices.

    // using hashmap
    private static int countNicePairs(int[] arr) {
        // instead of arr[i] + rev(arr[j]) == arr[j] + rev(arr[i])
        // we can also write them as arr[i] - rev(arr[i]) == arr[j] - rev(arr[j])

        HashMap<Integer, Integer> map = new HashMap<>();  // will store arr[i] - reverse(arr[i]) and its freq

        int count = 0;
        for(int ele : arr) {
            ele = ele - reverse(ele);
            if (map.containsKey(ele)){
                count += map.get(ele); // pehle agar jitne present hai un sabke sath pair banayega
                count %= 1000000007;
            }
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        return count;
    }

    // TC = O(n^2) (Brute force)
//    private static int countNicePairs(int[] arr) {
//        int count = 0;
//        int n = arr.length;
//        for(int i=0; i<n; i++){
//            for(int j=i+1; j<n; j++){
//                if(arr[i] + reverse(arr[j]) == reverse(arr[i]) + arr[j]) count++;
//            }
//        }
//        return count;
//    }

    private static int reverse(int n) {
        int rev = 0;
        while(n!=0){
            rev = rev*10 + n%10;
            n/=10;
        }
        return rev;
    }
}