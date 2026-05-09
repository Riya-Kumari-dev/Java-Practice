package dsa.recursion;

import java.util.Scanner;

public class CountAndSay {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        System.out.println(countAndSay(n));
    }
    static String countAndSay( int n){
        if(n==1) return "1";
        String s = countAndSay(n-1);
        StringBuilder ans = new StringBuilder();
        int i=0;
        int j=0;
        while(j<s.length()) {
            char ch = s.charAt(i);
            if (s.charAt(j) == ch) j++;
            else {
                int freq = j - i;
                ans.append(freq);
                ans.append(ch);
                i = j;
            }
        }
        int freq = j - i;
        ans.append(freq);
        ans.append(s.charAt(i));
        return ans.toString();
    }
}
