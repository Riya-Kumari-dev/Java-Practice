package dsa.collections.linkedlist;

import java.util.Scanner;

public class ReverseNodesInKGroup {
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
        System.out.print("Enter k : ");
        int k = sc.nextInt();
        l.display();
        Node newHead = reverseKGroup(l.getHead(), k);
        l.setHead(newHead);
        l.display();
    }
    private static Node reverseKGroup(Node head, int k) {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node temp = dummy;
        while(true){
            Node t = temp;
            for(int i=0; i<k && t!=null; i++){
                t = t.next;
            }
            if(t==null) break;
            Node nextGroup = t.next;
            // reverse
            Node prev = nextGroup;
            Node curr = temp.next;
            while(curr != nextGroup){
                Node Next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = Next;
            }
            Node a = temp.next;
            temp.next = t;
            temp = a;
        }
        return dummy.next;
    }
}