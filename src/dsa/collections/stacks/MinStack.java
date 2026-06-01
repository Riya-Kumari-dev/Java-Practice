package dsa.collections.stacks;

import java.util.Stack;

// fill the functions all should be in O(1) TC
public class MinStack {
    // TC = O(1) SC = O(1)
    Stack<Long > st;
    long min;
    public MinStack(){
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }
    public void push(int val) {
        long x = (long) val;
        if(st.isEmpty()){
            min = x;
            st.push(x);
        }
        // stack me fake value daalo
        // min > x => x-min<0 => x+x-min < x => 2x-min<x
        else if(min > x){
            min = x;
            st.push(2*x-min);
        }
        else st.push(x); // x < min
    }

    public void pop(){
        if(st.peek() < min) { // kuch to locha hai
            min = 2*min-st.peek();
        }
        st.pop();
    }
    public int top(){
        long top = st.peek();
        if(top<min) return (int)min;
        else return (int)top;
    }
    public int getMin(){
        return (int)min;
    }

    // TC = O(1) SC = O(n)
//    Stack<Integer> st;
//    Stack<Integer> minSt;
//    public MinStack(){
//        st = new Stack<>();
//        minSt = new Stack<>();
//    }
//    public void push(int val) {
//        st.push(val);
//        if (minSt.isEmpty() || minSt.peek() > val) minSt.push(val);
//        else minSt.push(minSt.peek());
//    }
//
//    public void pop(){
//        st.pop();
//        minSt.pop();
//    }
//    public int top(){
//        return st.peek();
//    }
//    public int getMin(){
//        return minSt.peek();
//    }
}