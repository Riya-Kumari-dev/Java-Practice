package dsa.collections.linkedlist;

public class SinglyLinkedList{
    private Node head;
    private Node tail;
    private int size = 0;
    boolean isEmpty(){
        return head == null;
    }
    void setHead(Node head){
        this.head = head;
    }
    Node getHead(){
        return this.head;
    }
    void addAtTail(int val){
        Node c = new Node(val);
        if(isEmpty()){
            tail = c;
            head = tail;
        }
        else{
            tail.next = c;
            tail = c;
        }
        size++;
    }
    void addAtHead(int val){
        Node c = new Node(val);
        if(isEmpty()) {
            tail = c;
            head = tail;
        }
        else{
            c.next = head;
            head = c;
        }
        size++;
    }
    void add(int idx, int val) throws Exception{
        if(idx == size) {
            addAtTail(val);
            return;
        }
        if(idx== 0){
            addAtHead(val);
            return;
        }
        if(idx<0 || idx>size) {
            throw new Exception("Index out of Bound");
        }
        Node temp  = head;
        for(int i=1; i<idx; i++) {
            temp = temp.next;
        }
        Node d = new Node(val);
        d.next = temp.next;
        temp.next = d;
        size++;
    }
    void removeFromEnd() throws Exception{
        if(isEmpty()) {
            throw new Exception("Linked list is empty");
        }
        if(size==1){
            head = tail = null;
        }
        else{
            Node temp = head;
            while(temp.next!=tail){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
        size--;
    }
    void removeFromHead() throws Exception{
        if(isEmpty()) {
            throw new Exception("Linked list is empty");
        }
        if(size==1)  head = tail = null;
        else head = head.next;
        size--;
    }
    void remove(int idx) throws Exception{
        if(isEmpty()) {
            throw new Exception("Linked list is empty");
        }
        if(idx == size-1) {
            removeFromEnd();
            return;
        }
        if(idx == 0) {
            removeFromHead();
            return;
        }
        if(idx<0 || idx>size) {
            throw new Exception("Index out of Bound");
        }
        if(size==1){
            head = tail = null;
        }
        else{
            Node temp = head;
            for(int i=0; i<idx-1; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        size--;
    }
    int get(int idx) throws Exception{
        if(idx == size-1) {
            return tail.val;
        }
        if(idx<0 || idx>size) {
            throw new Exception("Index out of Bound");
        }
        Node temp = head;
        for(int i=0; i<idx; i++){
            temp = temp.next;
        }
        return temp.val;
    }
    Node getNode(int idx) throws Exception{
        if(idx == size-1) {
            return tail;
        }
        if(idx<0 || idx>size) {
            throw new Exception("Index out of Bound");
        }
        Node temp = head;
        for(int i=0; i<idx; i++){
            temp = temp.next;
        }
        return temp;
    }
    void set(int idx, int val) throws Exception{
        if(idx == size-1) {
            tail.val = val;
        }
        if(idx<0 || idx>size) {
            throw new Exception("Index out of Bound");
        }
        Node temp = head;
        for(int i=0; i<idx; i++){
            temp = temp.next;
        }
        temp.val = val;
    }
    void size(){
        System.out.println("Length of the linked list is "+size);
    }
    void display(){
        Node temp = head;
        System.out.print("[");
        while(temp!=null){
            System.out.print(temp.val);
            if(temp.next!=null) System.out.print(", ");
            temp = temp.next;
        }
        System.out.print("]");
        System.out.println();
    }
}
