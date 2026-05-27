package dsa.collections.stacks;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesesChecker {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string consist of only parentheses : ");
        String s = sc.nextLine();
        if(isBalanced(s)) System.out.println("Yes, " +s+ " is balanced.");
        else System.out.println("No, "+s+" is not balanced.");
    }

    private static boolean isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i<s.length()) {
            char ch = s.charAt(i);
            if (ch == ')' || ch == '}' || ch == ']') {
                if(st.isEmpty()) return false;
                if (ch == ')' && st.peek() == '(') st.pop();
                else if (ch == '}'&& st.peek() == '{') st.pop();
                else if (ch == ']' && st.peek() == '[') st.pop();
                else return false;
            }
            else st.push(ch);
            i++;
        }
        return st.isEmpty();
    }
}