package dsa.collections.stacks;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an infix expression : ");
        String s = sc.nextLine();
        System.out.println("Infix : "+s);
        System.out.println("Postfix : "+infixToPostfix(s));
    }

    private static int priority(char op){
        if(op == '^') return 3;
        if(op == '+' || op == '-') return 1;
        if(op == '*' || op == '/') return 2;
        return 0;
    }

    private static void evaluate(Stack<String> val, Stack<Character> op){
        String v2 = val.pop();
        String v1 = val.pop();
        char operator = op.pop();
        String t = v1+" "+ v2+" " +operator;
        val.push(t);
    }
    private static String infixToPostfix(String s) {
        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();
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
            else if(ch == '(') op.push(ch);
            else if(ch == ')'){
                while (op.peek() != '(') {
                    // work
                    evaluate(val, op);
                    // now don't push the ')'
                }
                // remove the '('
                op.pop();
            }
            else{ // ch == '+' || ch == '-' || ch == '*' || ch == '/' // ch == '^'
                while(!op.isEmpty() && op.peek() != '(' && priority(op.peek()) >= priority(ch)){
                    evaluate(val, op);
                }
                // push the current operator
                op.push(ch);
            }
        }
        while(!op.isEmpty()){
            evaluate(val, op);
        }
        return val.peek();
    }
}