package dsa.collections.linkedlist;

import java.util.Scanner;

public class AddTwoNumbers {
    static void main(String[] args) {
        SinglyLinkedList l = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the fist linked list : ");
        int n = sc.nextInt();
        System.out.print("Enter " + n + " elements for the first linked list : ");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            try {
                l.add(i, val);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        SinglyLinkedList l2 = new SinglyLinkedList();
        System.out.print("Enter the size of the second linked list : ");
        int m = sc.nextInt();
        System.out.print("Enter " + m + " elements for the second linked list : ");
        for (int i = 0; i < m; i++) {
            int val = sc.nextInt();
            try {
                l2.add(i, val);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        l.display();
        l2.display();
        Node newHead = addTwoNumbers(l.getHead(), l2.getHead());
        l.setHead(newHead);
        l.display();
    }
    // You are given two non-empty linked lists representing two non-negative integers.
    // The digits are stored in reverse order, and each of their nodes contains a single digit.
    // Add the two numbers and return the sum as a linked list.
    private static Node addTwoNumbers(Node head, Node head1) {
        Node temp1 = head;
        Node temp2 = head1;
        Node dummy = new Node(-1);
        Node temp = dummy;
        int carry = 0;
        while(temp1!=null || temp2!=null){
            int x = 0;
            int y = 0;
            if(temp1 != null) x = temp1.val;
            if(temp2 != null) y = temp2.val;
            int sum = x+y+carry;
            carry = sum/10;
            temp.next = new Node(sum%10);
            temp = temp.next;
            if(temp1!= null) temp1 = temp1.next;
            if(temp2!= null) temp2 = temp2.next;
        }
        if(carry > 0) temp.next = new Node(carry);
        return dummy.next;
    }
}