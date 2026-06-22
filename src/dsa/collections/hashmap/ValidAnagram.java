package dsa.collections.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ValidAnagram {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string : ");
        String s1 = sc.nextLine();
        System.out.print("Enter second string : ");
        String s2 = sc.nextLine();

        if(areAnagrams(s1,s2)) System.out.println(s1 + " and " + s2 + " are anagrams of each other.");
        else System.out.println(s1 + " and " + s2 + " are not anagrams of each other.");
    }

    // using hashmaps
    // TC = O(n) = SC
    private static boolean areAnagrams(String s1, String s2) {
        // size not match => can't be anagrams , return false
        if(s1.length() != s2.length()) return false;
        HashMap<Character, Integer> m = new HashMap<>();
        // put the s1 in map
        for(int i=0; i<s1.length(); i++) {
            m.put(s1.charAt(i), m.getOrDefault(s1.charAt(i), 0)+1);
        }

        // iterate through s2 and find their freq, should be equal to s1's freq of each element
        for(int i=0; i<s2.length(); i++){
            char ch = s2.charAt(i);
            if(!m.containsKey(ch)) return false;
            if(m.get(ch) == 1) {
                m.remove(ch);
            }
            else m.put(ch, m.get(ch)-1);
        }
        return true;
    }

    // using sorting
    // TC = O(nlog(n))
//    private static boolean areAnagrams(String s1, String s2) {
//        if(s1.length() != s2.length()) return false;
//        char[] arr = s1.toCharArray();
//        char[] brr = s2.toCharArray();
//
//        Arrays.sort(arr);
//        Arrays.sort(brr);
//
//        for(int i=0; i<arr.length; i++){
//            if(arr[i] != brr[i]) return false;
//        }
//        return true;
//    }
}