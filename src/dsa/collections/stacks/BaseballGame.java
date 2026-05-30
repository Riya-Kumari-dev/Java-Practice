package dsa.collections.stacks;

import java.util.Scanner;
import java.util.Stack;

public class BaseballGame {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the operations : ");
        int n = sc.nextInt();
        String[] operations = new String[n];
        System.out.print("Enter the operations : ");
        for(int i=0; i<n; i++){
            operations[i] = sc.next();
        }
        System.out.println("Total Points are "+calPoints(operations));
    }
    // You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:
    //
    //An integer x.
    //Record a new score of x.
    //'+'.
    //Record a new score that is the sum of the previous two scores.
    //'D'.
    //Record a new score that is the double of the previous score.
    //'C'.
    //Invalidate the previous score, removing it from the record.
    //Return the sum of all the scores on the record after applying all the operations.
    private static int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(String s : operations){
            if(s.equals("+")){
                int a = st.pop();
                int b = st.peek();
                st.push(a);
                st.push(a+b);
            }
            else if(s.equals("D")){
                st.push(st.peek()*2);
            }
            else if(s.equals("C")) {
                st.pop();
            }
            else st.push(Integer.parseInt(s));
        }
        int sum = 0;
        while(!st.isEmpty()) sum += st.pop();
        return sum;
    }
}