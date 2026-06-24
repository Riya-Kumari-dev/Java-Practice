package dsa.collections.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class UniqueLength3PalindromicSubsequence {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String s = sc.nextLine();

        System.out.print("Total Number of unique palindromes of length three that are a subsequence of "+s+" are "+countPalindromicSubsequences(s));
    }

    private static int countPalindromicSubsequences(String s) {
        // use two hashmaps two store first and last occurence of each characters in s
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!map1.containsKey(ch)) map1.put(ch, i);
            else map2.put(ch, i);
        }

        // now iterate through first occurrence map
        int count = 0;
        for(char ch : map1.keySet()){
            // if the last occurrence map has also that ch, then count the number of unique characters between them using hashset, that will be total palindromic subsequence between them
            if(map2.containsKey(ch)) {
                int i=map1.get(ch);
                int j = map2.get(ch);
                HashSet<Character> set = new HashSet<>();
                for(int idx = i+1; idx<j; idx++){
                    set.add(s.charAt(idx));
                }
                count += set.size();
            }
            // if not present in last occurrence map then ch is occurring once in the string
            // that means it can't form palindromic subsequence
        }
        return count;
    }
}