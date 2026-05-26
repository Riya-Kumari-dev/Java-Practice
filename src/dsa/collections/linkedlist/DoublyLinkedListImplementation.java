package dsa.collections.linkedlist;

class ListNode{
    int val;
    ListNode next;
    ListNode prev;
    ListNode(int val){
        this.val = val;
    }
}
class DoublyLinkedList{
    ListNode head;
    ListNode tail;
    int size;
    void display(){
        System.out.print("[");
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val);
            if(temp.next !=null) System.out.print(",");
            temp = temp.next;
        }
        System.out.println("]");
    }
    void AddAtHead(int val){
        ListNode t = new ListNode(val);
        if(size == 0) {
            head = tail = t;
        }
        else{
            head.prev = t;
            t.next = head;
            head = t;
        }
        size++;
    }
    void AddAtTail(int val){
        ListNode t = new ListNode(val);
        if(size == 0) {
            head = tail = t;
        }
        else{
            tail.next = t;
            t.prev = tail;
            tail = t;
        }
        size++;
    }
    void add(int idx, int val){
        if(idx == 0) {
            AddAtHead(val);
            return;
        }
        if(idx == size) {
            AddAtTail(val);
            return;
        }
        ListNode t = new ListNode(val);
        ListNode temp = head;
        for(int i=1; i<idx; i++){
            temp = temp.next;
        }
        t.next = temp.next;
        temp.next.prev = t;
        t.prev = temp;
        temp.next = t;
        size++;
    }
    void deleteFromHead() throws Exception{
        if(isEmpty()) {
            throw new Exception("Linked list is empty");
        }
        if(size == 1){
            head = tail = null;
            size--;
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }
    void deleteFromTail() throws Exception{
        if(isEmpty()) {
            throw new Exception("Linked list is empty");
        }
        if(size == 1){
            head = tail = null;
            size--;
            return;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
    }
    void delete(int idx) throws Exception{
        if(isEmpty()) {
            throw new Exception("Linked list is empty");
        }
        if(idx<0 || idx>size) {
            throw new Exception("Index out of Bound");
        }
        if(idx == 0) {
            deleteFromHead();
            return;
        }
        if(idx == size-1) {
            deleteFromTail();
            return;
        }
        if(size == 1){
            head = tail = null;
            size--;
            return;
        }
        ListNode temp = head;
        for(int i=1; i<idx; i++){
            temp = temp.next;
        }
        temp.next.next.prev = temp;
        temp.next = temp.next.next;
        size--;
    }
    boolean isEmpty(){
        return size == 0;
    }
}

public class DoublyLinkedListImplementation {
    static void main(String[] args) {
        try{
            DoublyLinkedList d = new DoublyLinkedList();
            d.AddAtHead(3);
            d.AddAtTail(4);
            d.add(1, 5);
            d.display();
            System.out.println(d.size);
            d.add(2,40);
            d.add(2,9);
            d.display();
            d.delete(1);
            d.display();
            d.deleteFromHead();
            d.display();
            System.out.println(d.size);
            d.delete(2);
            d.display();
            d.delete(1);
            d.display();
        }
        catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
}