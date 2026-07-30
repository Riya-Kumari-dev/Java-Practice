package dsa.dynamicprogramming;

import java.util.Scanner;

import static dsa.dynamicprogramming.LongestCommonSubsequence.longestCommonSubsequence;

public class DeleteOperationsFor2Strings {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first word : ");
        String word1 = sc.nextLine();
        System.out.print("Enter second word : ");
        String word2 = sc.nextLine();
        System.out.println("Minimum number of operations required to make "+word1+" and "+word2+" same is "+minDistance(word1, word2));

    }
    private static int minDistance(String word1, String word2) {
        return word1.length() + word2.length()- 2*longestCommonSubsequence(word1, word2);
    }
}