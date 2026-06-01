package dsa.collections.stacks;

import java.util.Scanner;
import java.util.Stack;

public class InfixEvaluation {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a expression : ");
        String s = sc.nextLine();
        int ans = infixEvaluation(s);
        System.out.println("Ans : "+ans);
    }
    private static int priority(char op){
        if(op == '+' || op == '-') return 1;
        if(op == '*' || op == '/') return 2;
        return 0;
    }

    private static void evaluate(Stack<Integer> val, Stack<Character> op){
        int v2 = val.pop();
        int v1 = val.pop();
        char operator = op.pop();
        switch(operator) {
            case '+': val.push(v1 + v2); break;
            case '-': val.push(v1 - v2); break;
            case '*': val.push(v1 * v2); break;
            case '/': val.push(v1 / v2); break;
        }
    }
    private static int infixEvaluation(String s) {
        Stack<Integer> val = new Stack<>();
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
                val.push(num);
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
            else{ // ch == '+' || ch == '-' || ch == '*' || ch == '/'
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