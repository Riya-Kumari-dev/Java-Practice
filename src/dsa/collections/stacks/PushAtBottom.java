package dsa.collections.stacks;

import java.util.Stack;

public class PushAtBottom {
    static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        pushAtBottom(s,50);
        System.out.println(s);
    }
    static void pushAtBottom(Stack<Integer> st, int val){
        // iteratively
//        Stack<Integer> s = new Stack<>();
//        while(!st.isEmpty()) s.push(st.pop());
//        st.push(val);
//        while(!s.isEmpty()) st.push(s.pop());

        // recursively
        if(st.isEmpty()) {
            st.push(val);
            return;
        }
        int top = st.pop();
        pushAtBottom(st, val);
        st.push(top);
    }
}