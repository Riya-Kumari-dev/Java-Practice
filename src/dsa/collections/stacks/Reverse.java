package dsa.collections.stacks;

import java.util.Stack;

public class Reverse {
    static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        System.out.println(s);
        reverse(s);
        System.out.println(s);
    }

    private static void reverse(Stack<Integer> s){
        // iterative
//        Stack<Integer> st = new Stack<>();
//        while(!s.isEmpty()){
//            st.push(s.pop());
//        }
//        Stack<Integer> st2 = new Stack<>();
//        while(!st.isEmpty()){
//            st2.push(st.pop());
//        }
//        while(!st2.isEmpty()){
//            s.push(st2.pop());
//        }

        // recursively
        if(s.size() <= 1) return;
        int top = s.pop();
        reverse(s);
        pushAtBottom(s, top);
    }
    private static void pushAtBottom(Stack<Integer> st, int val){
        if(st.isEmpty()) {
            st.push(val);
            return;
        }
        int top = st.pop();
        pushAtBottom(st, val);
        st.push(top);
    }
}
