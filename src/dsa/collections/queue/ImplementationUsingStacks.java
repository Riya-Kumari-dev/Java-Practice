package dsa.collections.queue;
import java.util.Stack;

// pop and peek efficient approach
//class MyQueue {
//    Stack<Integer> st;
//    Stack<Integer> helper;
//    public MyQueue() {
//        st = new Stack<>();
//        helper = new Stack<>();
//    }
//      // push at bottom
//    public void push(int x) {
//        if(st.isEmpty()) {
//            st.push(x);
//            return;
//        }
//        while(!st.isEmpty()){
//            helper.push(st.pop());
//        }
//        st.push(x);
//        while(!helper.isEmpty()){
//            st.push(helper.pop());
//        }
//    }
//
//    public int pop() {
//        if(st.isEmpty()) return -1;
//        return st.pop();
//    }
//
//    public int peek() {
//        if(st.isEmpty()) return -1;
//        return st.peek();
//    }
//
//    public boolean empty() {
//        return (st.isEmpty());
//    }
//}


// push efficient approach
class MyQueue {
    Stack<Integer> st;
    Stack<Integer> helper;
    public MyQueue() {
        st = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        st.add(x);
    }

    public int pop() {
        if(st.isEmpty()) return -1;
        while(st.size()>1){
            helper.push(st.pop());
        }
        int top = st.pop();
        while(!helper.isEmpty()){
            st.push(helper.pop());
        }
        return top;
    }

    public int peek() {
        if(st.isEmpty()) return -1;
        while(st.size()>1){
            helper.push(st.pop());
        }
        int top = st.peek();
        while(!helper.isEmpty()){
            st.push(helper.pop());
        }
        return top;
    }

    public boolean empty() {
        return (st.isEmpty());
    }
    public void display(){
        while(!st.isEmpty()){
            helper.push(st.pop());
        }
        System.out.print("[");
        while(!helper.isEmpty()){
            System.out.print(helper.peek());
            if(helper.size() != 1) System.out.print(",");
            st.push(helper.pop());
        }
        System.out.println("]");
    }
}
public class ImplementationUsingStacks {
    static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(10);
        q.push(20);
        q.push(30);
        q.push(40);
        q.display(); // [10,20,30,40]
        System.out.println(q.pop()); // 10
        System.out.println(q.peek()); // 20
        q.display(); // [20,30,40]
    }
}