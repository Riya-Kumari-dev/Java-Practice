package dsa.collections.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MostFrequentCharacter {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String s = sc.nextLine();
        System.out.println("The most frequent character in "+s+" is "+mostFrequent(s));
    }

    // using hashmap
    // TC = O(n) , SC = O(n)
    private static Character mostFrequent(String s) {
        // put in hashmap
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                int freq = map.get(ch);
                map.put(ch, freq+1);
            }
            else map.put(ch, 1);
        }

        // find maxFreq
        int maxFreq = 0;
        for(char ch : map.keySet()){
            int freq = map.get(ch);
            if(freq > maxFreq) maxFreq = freq;
        }

        // find the character with maxFreq
        char ans = 'z';
        for(char ch : map.keySet()){
            int freq = map.get(ch);
            if(freq == maxFreq && ch <= ans){ // if more than one with maxFreq then smallest one will be the answer
                ans = ch;
            }
        }
        return ans;
    }


    // using freq array
    // TC = O(n) = SC
//    private static Character mostFrequent(String s) {
//        int[] freq = new int[26];
//        for(int i=0; i<s.length(); i++){
//            char ch = s.charAt(i);
//            int idx = (int)ch-97;
//            freq[idx]++;
//        }
//
//        int maxFreq = 0;
//        char ans = s.charAt(0);
//        for(int i=0; i<freq.length; i++){
//            if(maxFreq < freq[i]) {
//                maxFreq = freq[i];
//                ans = (char)(97+i);
//            }
//        }
//        return ans;
//    }

    // two pointer approach
//    private static Character mostFrequent(String s) {
//        char[] arr = s.toCharArray();
//        Arrays.sort(arr);
//        int i=0;
//        int j=0;
//        int maxFreq = -1;
//        char ans = arr[0];
//        while(j<arr.length){
//            char ch = arr[i];
//            while(j<arr.length && arr[j] == ch) j++;
//            int freq = j-i;
//            if(freq>maxFreq){
//                maxFreq = freq;
//                ans = ch;
//            }
//            i=j;
//        }
//        if((j-i) > maxFreq) {
//            maxFreq = j-i;
//            ans = arr[i];
//        }
//        return ans;
//    }


    // brute force
//    private static Character mostFrequent(String s) {
//        int maxFreq = -1;
//        char ans = s.charAt(0);
//        for(int i=0; i<s.length(); i++){
//            char ch = s.charAt(i);
//            int freq = 1;
//            for(int j=i+1; j<s.length(); j++){
//                if(ch == s.charAt(j)) freq++;
//            }
//            if(freq > maxFreq){
//                maxFreq = freq;
//                ans = ch;
//            }
//            else if(freq == maxFreq && ch<ans){
//                ans = ch;
//            }
//        }
//        return ans;
//    }
}