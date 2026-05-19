package dsa.collections.linkedlist;

import java.util.Scanner;

public class SortList {
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
        Node head = sort(l.getHead());
        l.setHead(head);
        l.display();
    }

    private static Node sort(Node head) {
        if(head == null || head.next == null) return head;
        // divide the list in two halves
        // find the left middle node
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node second = slow.next;
        slow.next = null;
        // let's do the magic => recursion
        head = sort(head);
        second = sort(second);
        // merge the two sorted lists
        return merge(head,second);
    }
    private static Node merge(Node head, Node head1) {
        Node temp1 = head;
        Node temp2 = head1;
        Node dummy = new Node(-1);
        Node temp = dummy;
        while(temp1!= null && temp2!= null){
            if(temp1.val <= temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }
            else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp1!= null) temp.next = temp1;
        if(temp2 != null) temp.next = temp2;
        return dummy.next;
    }
}