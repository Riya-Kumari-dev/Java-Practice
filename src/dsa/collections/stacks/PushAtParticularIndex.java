package dsa.collections.stacks;

import java.util.Stack;

public class PushAtParticularIndex {
    static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);

        System.out.println(st);
        int val = 60;
        int idx = 3; // from bottom
        pushAtIndex(st, val, idx);
        System.out.println(st);
    }

    private static void pushAtIndex(Stack<Integer> st, int val, int idx) {
        // iterative
//        Stack<Integer> s = new Stack<>();
//        while(st.size()>idx){
//            s.push(st.pop());
//        }
//        st.push(val);
//        while(!s.isEmpty()) st.push(s.pop());

        // recursive
        if(st.size() == idx){
            st.push(val);
            return;
        }
        int top = st.pop();
        pushAtIndex(st, val, idx);
        st.push(top);
    }
}
