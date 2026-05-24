package dsa.collections.linkedlist;

import java.util.Scanner;

public class ReverseLinkedList {
    static void main(String[] args) {
        SinglyLinkedList l = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the linked list : ");
        int n = sc.nextInt();
        System.out.print("Enter " + n + " elements for the linked list : ");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            try {
                l.add(i, val);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        l.display();
        Node newHead = reverse(l.getHead());
        l.setHead(newHead);
        l.display();
    }
    public static Node reverse(Node head) {
        // iterative TC = O(n) SC = O(1)
        Node prev = null;
        Node curr = head;
        Node Next = head;
        while(curr!=null){
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        return prev;
        // recursive  TC = O(n) SC = O(n) call stack space
//        if(head == null || head.next == null) return head;
//        Node a = head.next;
//        Node newHead = reverse(a);
//        a.next = head;
//        head.next = null;
//        return newHead;
    }
}