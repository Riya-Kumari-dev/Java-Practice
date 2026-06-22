package dsa.collections.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class PairWithDifferenceK {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of the array : ");
        int m = sc.nextInt();
        int[] a = new int[m];
        System.out.print("Enter " + m + " elements for the given array : ");
        for(int i=0; i<m; i++){
            a[i] = sc.nextInt();
        }
        System.out.print("Enter k : ");
        int k = sc.nextInt();
        System.out.println("There are "+countPairs(a, k)+" elements with difference equal to "+k+" in "+ Arrays.toString(a));
    }

    private static int countPairs(int[] a, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int count = 0;
        for(int ele : a){
            m.put(ele, m.getOrDefault(ele, 0)+1);
        }
        for(int ele : m.keySet()){
            int rem1 = ele - k;
            int rem2 = ele + k;
            if(m.containsKey(rem1)) count += (m.get(ele) * m.get(rem1));
            if(m.containsKey(rem2)) count += (m.get(ele) * m.get(rem2));
        }
        count /= 2;
        return count;
    }
}
