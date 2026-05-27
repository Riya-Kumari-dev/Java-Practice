package dsa.collections.stacks;

class Node {
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}
class MyStack {
    Node head;
    int size = 0;
    void push(int val){
        Node t = new Node(val);
        if(isEmpty()){
            head = t;
            size++;
            return;
        }
        t.next = head;
        head = t;
        size++;
    }
    int pop()throws Exception{
        if(isEmpty()) {
            throw new Exception("Stack is empty");
        }
        int top = head.val;
        head = head.next;
        size--;
        return top;
    }
    int peek() throws Exception{
        if(isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return head.val;
    }
    void display(){
        Node temp = head;
        System.out.print("[");
        while(temp!=null){
            System.out.print(temp.val);
            if(temp.next!=null) System.out.print(", ");
            temp = temp.next;
        }
        System.out.println("]");
    }
    boolean isEmpty(){
        return (size == 0);
    }
}

public class ImplementationUsingLinkedList {
    static void main(String[] args) {
        try{
            MyStack st = new MyStack();
            //System.out.println(st.peek());
            st.push(10);
            st.push(20);
            st.push(30);
            st.push(40);
            st.display(); // [40, 30, 20, 10]
            st.pop();
            System.out.println(st.peek()); // 30
            System.out.println(st.pop()); // 30
            st.display(); // [20, 10]
            System.out.println(st.size); // 2
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}