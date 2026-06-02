package dsa.collections.stacks;

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluation {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a postfix expression : ");
        String s = sc.nextLine();
        System.out.println("Ans : "+postfixEvaluation(s));
    }
    private static void evaluate(Stack<Integer> val, String op){
        int v2 = val.pop();
        int v1 = val.pop();
        switch(op) {
            case "^" : val.push((int)Math.pow(v1,v2)); break;
            case "+" : val.push(v1 + v2); break;
            case "-": val.push(v1 - v2); break;
            case "*": val.push(v1 * v2); break;
            case "/" : val.push(v1/v2); break;
        }
    }
    private static int postfixEvaluation(String s) {
        // we can type multidigit also to separate them make sure we take input with spaces to avoid conflict
        String[] exp = s.split(" "); // split on the basis of " "
        Stack<Integer> val = new Stack<>();
        for(String t : exp){
            // operator
            if(t.equals("^") || t.equals("+") || t.equals("-")  || t.equals("*") || t.equals("/")){
                // do the work
                evaluate(val, t);
            }
            else{ // integer
                val.push(Integer.parseInt(t));
            }
        }
        return val.peek();
    }
}