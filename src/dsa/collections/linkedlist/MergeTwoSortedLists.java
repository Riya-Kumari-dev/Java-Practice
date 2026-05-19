package dsa.collections.linkedlist;

import java.util.Scanner;

public class MergeTwoSortedLists {
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
        Node newHead = merge(l.getHead(), l2.getHead());
        l.setHead(newHead);
        l.display();
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