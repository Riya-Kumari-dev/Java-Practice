package dsa.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Permutations {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String s = sc.nextLine();
        ArrayList<String> finalAns = new ArrayList<>();
        permutations(s, "", finalAns);
        System.out.println("Permutations of the "+s+" are "+finalAns);
    }
    // TC = O(n!)
    private static void permutations(String s, String ans,  ArrayList<String> finalAns) {
        if(s.length() == 0) {
            finalAns.add(ans);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String left  = s.substring(0, i);
            String right = s.substring(i + 1);
            permutations(left + right, ans +ch,finalAns);
        }
    }
}