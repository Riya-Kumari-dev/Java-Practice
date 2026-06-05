package dsa.collections.queue;

class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}
class queue{
    Node head;
    Node tail;
    int size = 0;
    void add(int val){
        Node t = new Node(val);
        if(size == 0){
            head = tail = t;
        }
        else{
            tail.next = t;
            tail = t;
        }
        size++;
    }
    int remove() throws Exception{
        if(size == 0){
            throw new Exception("Queue Underflow Error");
        }
        int top = head.val;
        head = head.next;
        size--;
        return top;
    }
    int peek() throws Exception{
        if(size == 0){
            throw new Exception("Queue Underflow Error");
        }
        return head.val;
    }
    boolean isEmpty(){
        return (size==0);
    }
    void print(){
        Node temp = head;
        System.out.print("[");
        while(temp!=null){
            System.out.print(temp.val);
            if(temp.next!=null) System.out.print(",");
            temp = temp.next;
        }
        System.out.println("]");
    }
}
public class ImplementationViaLinkedList {
    static void main(String[] args) {
        try{
            queue q = new queue();
            //System.out.println(q.peek());
            q.add(10);
            q.add(20);
            q.add(30);
            q.add(40);
            q.print(); // [10,20,30,40]
            System.out.println(q.remove()); // 10
            System.out.println(q.peek()); // 20
            q.print(); // [20,30,40]
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}