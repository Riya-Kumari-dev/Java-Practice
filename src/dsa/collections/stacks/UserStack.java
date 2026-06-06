package dsa.collections.stacks;

import java.util.LinkedList;
import java.util.Queue;

// pop and peek efficient approach

//class UserStack {
//    Queue<Integer> q;
//    public UserStack() {
//        q = new LinkedList<>();
//    }
//
//    public void push(int x) {
//        q.add(x);
//        if(q.size()>1){
//            int n = q.size();
//            for(int i=1; i<n; i++) q.add(q.remove());
//        }
//    }
//
//    public int pop() {
//        if(q.size() == 0) return -1;
//        else return q.remove();
//    }
//
//    public int top() {
//        if(q.size() == 0) return -1;
//        else return q.peek();
//    }
//
//    public boolean empty() {
//        return (q.size()==0);
//    }
//}

// push efficient approach
class UserStack {
    Queue<Integer> q;
    public UserStack() {
        q = new LinkedList<>();
    }
    public void push(int x) {
        q.add(x);
    }

    public int pop() {
        if(q.isEmpty()) return -1;
        if(q.size()==1) return q.remove();
        int n = q.size();
        for(int i=1; i<n; i++){
            q.add(q.remove());
        }
        return q.remove();
    }

    public int top() {
        if(q.isEmpty()) return -1;
        if(q.size()==1) return q.peek();
        int n = q.size();
        for(int i=1; i<n; i++){
            q.add(q.remove());
        }
        int top = q.remove();
        q.add(top);
        return top;
    }

    public boolean empty() {
        return (q.isEmpty());
    }
}
