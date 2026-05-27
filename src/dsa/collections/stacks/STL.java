package dsa.collections.stacks;

import java.util.Stack;

public class STL {
    static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        // push(item)
        // pushes an item onto the top of the MyStack
        st.push(10);
        st.push(20);
        st.push(30);

        // addElement(obj) => same as push
        st.addElement(40);

        System.out.println(st); // [10, 20, 30, 40]

        // pop()
        // removes the object at the top of this MyStack and returns the object as the value of this function
        // throws EmptyStackException - if the MyStack is empty
        st.pop();
        System.out.println(st.pop()); // 30

        // peek()
        // looks at the object at the top of the MyStack without removing it from the MyStack
        // throws EmptyStackException - if the MyStack is empty
        System.out.println(st.peek()); // 20

        // empty()
        // returns true if and only if the MyStack is empty
        System.out.println(st.empty()); // false

        // search
        // returns the 1 based position where an object is on the MyStack
        // if the object is not present returns -1
        System.out.println(st.search(20)); // 1
        System.out.println(st.search(40)); // -1
    }
}