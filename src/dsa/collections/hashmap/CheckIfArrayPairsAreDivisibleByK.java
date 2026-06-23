package dsa.collections.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CheckIfArrayPairsAreDivisibleByK {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter k : ");
        int k = sc.nextInt();

        if(canArrange(arr, k)) System.out.println("Yes, "+ Arrays.toString(arr)+" have "+(n/2)+" pairs which are divisible by "+k);
        else System.out.println("No, "+ Arrays.toString(arr)+" does not  have "+(n/2)+" pairs which are divisible by "+k);
    }

    // Given an array of integers arr of even length n and an integer k.
    //We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
    //Return true If you can find a way to do that or false otherwise.


    private static boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : arr){
            int a = ele % k;
            if(a<0) a += k; // to be positive
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        // if already divisible by k => that means map will contain them as 0
        if(map.containsKey(0)) {
            if(map.get(0) % 2 != 0) return false; // mean pair nhi bana payenge ek na ek bach jayega
            map.remove(0);
        }

        // if k/2 is present in map then it will check through itself thus wrong answer can get as it will check its frequency to itself which will always be same , so it should be handled carefully
        // if(k%2 == 0 && map.containsKey(k/2)) {
        //     if(map.get(k/2) % 2 != 0) return false; // mean pair nhi bana payenge ek na ek bach jayega
        //     map.remove(k/2);
        // }

        // 👆 commented because the question asked for exact n/2 pairs that means the array is of odd length always

        for(int key : map.keySet()){
            int rem = k - key;
            if(!map.containsKey(rem)) return false;

            int keyFreq = map.get(key);
            int remFreq = map.get(rem);
            if(keyFreq != remFreq) return false;
        }
        return true;
    }
}