package dsa.collections.linkedlist;

import java.util.Scanner;

public class MiddleOfLinkedList {
    static void main(String[] args) throws Exception{
        SinglyLinkedList l = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the linked list : ");
        int n = sc.nextInt();
        System.out.print("Enter "+n+" elements for the linked list : ");
        for(int i=0; i<n; i++){
            int val = sc.nextInt();
            l.add(i, val);
        }
        l.display();
        System.out.print(middleNode(l.getHead()).val);
    }
    // Given the head of a singly linked list, return the middle node of the linked list.
    //If there are two middle nodes, return the second middle node.
    private static Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}