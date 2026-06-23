package dsa.collections.hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class CountNumberOfEqualPairsInString {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String s = sc.nextLine();

        System.out.println("Number of equal pairs in "+s+" are "+equalPairs(s));
    }

    private static long equalPairs(String s) {
        HashMap<Character, Integer> m = new HashMap<>();
        for(int i=0; i<s.length(); i++) m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0)+1);

        long pairs = 0;
        for(char ch : m.keySet()){
            long freq = m.get(ch);
            pairs += (freq*freq);
        }
        return pairs;
    }
}