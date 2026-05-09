package dsa.recursion;

import java.util.Scanner;

public class SkipCharacter {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String s = sc.nextLine();
        StringBuilder ans = new StringBuilder();
        skipA(s, 0, ans);
        System.out.println(ans);
    }

    private static void skipA(String s, int i, StringBuilder ans) {
        if(i==s.length()) return;
        if(s.charAt(i) != 'a' && s.charAt(i) != 'A'){
            skipA(s, i+1, ans.append(s.charAt(i)));
        }
        else skipA(s, i+1, ans);
    }
}