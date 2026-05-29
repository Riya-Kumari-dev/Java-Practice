package dsa.collections.linkedlist;

public class Display {
    static void main(String[] args) {
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);

        a.next = b;
        b.next = c;
        c.next = d;

        display(a); // 2 3 4 5
        displayRec(a); // 2 3 4 5
    }

    private static void displayRec(Node head) {
        if(head == null) return;
        System.out.print(head.val+" ");
        displayRec(head.next);
    }

    private static void display(Node head) {
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}