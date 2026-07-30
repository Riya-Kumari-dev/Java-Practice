package dsa.dynamicprogramming;

import java.util.Scanner;

import static dsa.dynamicprogramming.PrintLongestCommonSubsequence.lcs;

public class ShortestCommonSupersequence {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string : ");
        String s1 = sc.nextLine();
        System.out.print("Enter second string : ");
        String s2 = sc.nextLine();
        System.out.println("Shortest common supersequence in "+s1+" and "+s2+" is "+shortestCommonSupersequence(s1,s2));
    }
    private static String shortestCommonSupersequence(String s1, String s2) {
        String lc = lcs(s1, s2);
        int i=0;  // for s1
        int j=0; // for s2
        int k = 0; // for Lcs
        String ans = "";
        while(k<lc.length()){
            while(s1.charAt(i) != lc.charAt(k)) {
                ans += s1.charAt(i);
                i++;
            }
            while(s2.charAt(j) != lc.charAt(k)){
                ans += s2.charAt(j);
                j++;
            }
            ans += lc.charAt(k);
            i++;
            j++;
            k++;
        }
        while(i<s1.length()) ans += s1.charAt(i++);
        while(j<s2.length()) ans += s2.charAt(j++);
        return ans;
    }
}