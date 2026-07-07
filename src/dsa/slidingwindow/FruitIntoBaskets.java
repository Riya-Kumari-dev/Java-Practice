package dsa.slidingwindow;

import java.util.HashMap;
import java.util.Scanner;

public class FruitIntoBaskets {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the fruits array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the fruits array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Maximum Consecutive fruits that we can pick are " +totalFruit(arr));
    }

    // You only have two baskets, and each basket can only hold a single type of fruit.
    // There is no limit on the amount of fruit each basket can hold.
    //Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right.
    // The picked fruits must fit in one of your baskets.
    //Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
    private static int totalFruit(int[] arr) {
        int n = arr.length;
        int i=0;
        int j=0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(j<n){
            map.put(arr[j], map.getOrDefault(arr[j], 0)+1);

            // if map size is greater than 2 then shrink the window
            while(map.size() > 2){
                int freq = map.get(arr[i]);
                if(freq == 1) map.remove(arr[i]);
                else map.put(arr[i], freq-1);
                i++;
            }
            // ab size 2 ya usse kam hai to find the current maximum fruits
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
}