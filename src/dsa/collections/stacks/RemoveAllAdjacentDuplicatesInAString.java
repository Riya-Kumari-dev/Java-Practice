package dsa.collections.stacks;

import java.util.Scanner;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInAString {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string : ");
        String s = sc.nextLine();
        String ans = removeDuplicates(s);
        System.out.println(ans);
    }
    private static String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(st.isEmpty() || st.peek()!=ch){
                st.push(ch);
            }
            else st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}