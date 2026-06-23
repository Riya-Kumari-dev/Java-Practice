package dsa.collections.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ThreeDigitEvenNumbers {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Three digits even numbers from "+ Arrays.toString(arr)+" are "+findEvenNumbers(arr));
    }

    private static ArrayList<Integer> findEvenNumbers(int[] digits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : digits) map.put(ele, map.getOrDefault(ele, 0)+1);

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=100; i<=999; i+=2){
            int x = i;
            int c = x%10; x/=10;
            int b = x%10; x/=10;
            int a = x%10; x/=10;

            if(map.containsKey(a)){
                int aFreq = map.get(a);
                if(aFreq == 1) map.remove(a);
                else map.put(a, aFreq-1);

                if(map.containsKey(b)){
                    int bFreq = map.get(b);
                    if(bFreq == 1) map.remove(b);
                    else map.put(b, bFreq-1);

                    if(map.containsKey(c)) ans.add(i);

                    map.put(b, bFreq);
                }
                map.put(a, aFreq);
            }
        }
        return ans;
    }
}