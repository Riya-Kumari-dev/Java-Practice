package dsa.collections.stacks;

import java.util.Scanner;
import java.util.Stack;

public class PostfixToPrefix {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a postfix expression : ");
        String s = sc.nextLine();
        System.out.println("Postfix : "+s);
        System.out.println("Prefix : "+postfixToPrefix(s));
    }

    private static String postfixToPrefix(String s) {
        Stack<String> val = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            // ignore spaces
            if(ch == ' ') continue;
                // if ch is a digit => can be multidigit also
            else if(Character.isDigit(ch)) {
                int num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                String t = ""+ num;
                val.push(t);
                i--;
            }
            // operators
            else evaluate(val, ch);
        }
        return val.peek();
    }
    private static void evaluate(Stack<String> val, char ch) {
        String v2 = val.pop();
        String v1 = val.pop();
        String t = ch+" "+v1+" "+ v2;
        val.push(t);
    }
}
