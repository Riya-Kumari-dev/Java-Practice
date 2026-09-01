package dsa.bitmanipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SingleNumber {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the given array : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("The only number in "+ Arrays.toString(arr)+" which appears only once is "+singleNumber(arr));
    }

    // TC = O(n), SC = O(1)
    private static int singleNumber(int[] arr) {
        int xor = 0;
        for(int ele :arr) xor ^= ele;
        return xor;
    }

    // TC = O(n), SC = O(n)
//    private static int singleNumber(int[] arr) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(int ele : arr) {
//            map.put(ele, map.getOrDefault(ele, 0)+1);
//        }
//        for(int key : map.keySet()){
//            if(map.get(key) ==1) return key;
//        }
//        return -1;
//    }

    // TC = O(nlog(n)) , SC = O(log(n))
//    private static int singleNumber(int[] arr) {
//        Arrays.sort(arr);
//        int i=0;
//        while(i<arr.length-1){
//            if(arr[i] != arr[i+1]) return arr[i];
//            i+=2;
//        }
//        return arr[arr.length-1];
//    }


    // Brute force
    // TC = O(n^2) , SC = O(1)
//    private static int singleNumber(int[] arr) {
//        for(int i=0; i<arr.length; i++){
//            boolean flag = true;
//            for(int j=0; j<arr.length; j++){
//                if(j==i) continue;
//                if(arr[i] == arr[j]) {
//                    flag = false;
//                    break;
//                }
//            }
//            if(flag) return arr[i];
//        }
//        return -1;
//    }
}