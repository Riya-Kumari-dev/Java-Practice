package dsa.collections.hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class SumOfBeautyOfAllSubstrings {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String s = sc.nextLine();

        System.out.println("Sum of beauty of all substrings of "+s+" is "+sumOfBeauty(s));
    }

    // The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.

    // using hashmap
    // TC = O(n^2*k) => k is of 26 range
    private static int sumOfBeauty(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++){
            HashMap<Character, Integer> m = new HashMap<>();
            for(int j=i; j<s.length(); j++){
                char ch = s.charAt(j);
                m.put(ch, m.getOrDefault(ch, 0)+1);
                int min = s.length();
                int max = 0;
                for(int values : m.values()){
                    min = Math.min(values, min);
                    max = Math.max(values, max);
                }
                count += max - min;
            }
        }
        return count;
    }

    // using freq array
    // TC = O(n^2*26)
//    private static int sumOfBeauty(String s) {
//        int count = 0;
//        for(int i=0; i<s.length(); i++){
//            int[] freq = new int[26];
//            for(int j=i; j<s.length(); j++){
//                char ch = s.charAt(j);
//                freq[ch-'a']++;
//                int min = s.length();
//                int max = 0;
//                for(int k=0; k<26; k++){
//                    if(freq[k] > 0){
//                        max = Math.max(max, freq[k]);
//                        min = Math.min(min, freq[k]);
//                    }
//                }
//                count += max - min;
//            }
//        }
//        return count;
//    }
}