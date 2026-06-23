package dsa.collections.hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatingCharacters {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String s = sc.nextLine();

        System.out.println("Length of the longest substring without duplicate characters in "+s+" is "+lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n<=1) return n;
        HashMap<Character, Integer> map = new HashMap<>(); // character and its index
        int i=0;
        int maxLength = 0;
        int j=0;
        while(j<n) {
            char ch = s.charAt(j);
            if(map.containsKey(ch) && map.get(ch) >=i){
                maxLength = Math.max(maxLength,j-i);

                // i ko lekar jao ch ki purani position se ek aage
                while(s.charAt(i) != ch) i++;
                i++; // ek aage
            }
            map.put(ch, j);
            j++;
        }

        maxLength = Math.max(maxLength, j-i);
        return maxLength;
    }
}