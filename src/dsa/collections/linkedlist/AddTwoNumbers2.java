package dsa.collections.linkedlist;

import java.util.Scanner;

import static dsa.collections.linkedlist.ReverseLinkedList.reverse;

public class AddTwoNumbers2 {
    static void main(String[] args) {
        SinglyLinkedList l = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the fist linked list : ");
        int n = sc.nextInt();
        System.out.print("Enter "+n+" elements for the first linked list : ");
        for(int i=0; i<n; i++){
            int val = sc.nextInt();
            try{
                l.add(i, val);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        SinglyLinkedList l2 = new SinglyLinkedList();
        System.out.print("Enter the size of the second linked list : ");
        int m = sc.nextInt();
        System.out.print("Enter "+m+" elements for the second linked list : ");
        for(int i=0; i<m; i++){
            int val = sc.nextInt();
            try{
                l2.add(i, val);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        l.display();
        l2.display();
        Node newHead = addTwoNumbers(l.getHead(), l2.getHead());
        l.setHead(newHead);
        l.display();
    }
    //  The most significant digit comes first and each of their nodes contains a single digit.
    private static Node addTwoNumbers(Node head, Node head1) {
        if(head != null && head.val == 0 && head1 !=null && head1.val == 0) return head1;
        Node dummy = new Node(-1);
        Node temp = dummy;
        // for leading zeroes
//        while(head != null && head.val == 0) head = head.next;
//        while(head1 != null && head1.val == 0) head1 = head1.next;
        head = reverse(head);
        head1 = reverse(head1);
        int carry = 0;
        while(head!=null || head1!=null){
            int x = 0;
            int y = 0;
            if(head != null) x = head.val;
            if(head1 != null) y = head1.val;
            int sum = x+y+carry;
            carry = sum/10;
            temp.next = new Node(sum%10);
            temp = temp.next;
            if(head!= null) head = head.next;
            if(head1!= null) head1 = head1.next;
        }
        if(carry > 0) temp.next = new Node(carry);
        dummy.next = reverse(dummy.next);
        return dummy.next;
    }
}
