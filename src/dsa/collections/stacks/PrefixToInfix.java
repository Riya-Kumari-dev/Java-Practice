package dsa.collections.stacks;

import java.util.Scanner;
import java.util.Stack;

public class PrefixToInfix {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a prefix expression : ");
        String s = sc.nextLine();
        System.out.println("Prefix : "+s);
        System.out.println("Infix : "+prefixToInfix(s));
    }

    private static String prefixToInfix(String s) {
        Stack<String> val = new Stack<>();
        for(int i=s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            // ignore spaces
            if(ch == ' ') continue;
                // if ch is a digit => can be multidigit also
            else if(Character.isDigit(ch)) {
                int num = 0;
                int place = 1;
                while(i >= 0 && Character.isDigit(s.charAt(i))) {
                    num = (s.charAt(i) - '0') * place+num;
                    place *= 10;
                    i--;
                }
                String t = ""+ num;
                val.push(t);
                i++;
            }
            // operators
            else evaluate(val, ch);
        }
        return val.peek();
    }

    private static void evaluate(Stack<String> val, char ch) {
        String v1 = val.pop();
        String v2 = val.pop();
        String t = "("+v1+" "+ch+" "+ v2+")";
        val.push(t);
    }
}