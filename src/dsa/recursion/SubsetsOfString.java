package dsa.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class SubsetsOfString {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String s = sc.nextLine();
        ArrayList<String> finalAns = new ArrayList<>();
        subset(s,0,"",finalAns);
        System.out.println("Subsets of " + s + " : "+finalAns);
    }

    private static void subset(String s, int i, String ans, ArrayList<String> finalAns) {
        if(i==s.length()) {
            finalAns.add(ans);
            return;
        }
        // skip
        subset(s,i+1,ans, finalAns);
        // take
        subset(s,i+1,ans+s.charAt(i), finalAns);
    }
}
