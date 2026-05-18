package dsa.collections.linkedlist;

import java.util.Scanner;

public class DeleteMiddleNodeOfLinkedList {
    static void main(String[] args) {
        SinglyLinkedList l = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the linked list : ");
        int n = sc.nextInt();
        System.out.print("Enter "+n+" elements for the linked list : ");
        for(int i=0; i<n; i++){
            int val = sc.nextInt();
            try{
                l.add(i, val);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        l.display();
        Node head2 = deleteMiddle(l.getHead());
        l.setHead(head2);
        l.display();
    }
    // delete the left middle if two middle present
    private static Node deleteMiddle(Node head) {
        // if null or 1 node
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next.next == null) {
            return head.next;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}