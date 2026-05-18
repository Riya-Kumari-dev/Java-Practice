package dsa.collections.linkedlist;

import java.util.Scanner;

public class RemoveNthNodeFromLinkedList {
    static void main(String[] args) {
        SinglyLinkedList l = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the linked list : ");
        int m = sc.nextInt();
        System.out.print("Enter "+m+" elements for the linked list : ");
        for(int i=0; i<m; i++){
            int val = sc.nextInt();
            try{
                l.add(i, val);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        l.display();
        Node head2 = removeNthFromEnd(l.getHead(), n);
        l.setHead(head2);
        l.display();
    }

    private static Node removeNthFromEnd(Node head, int n) {
        Node slow = head;
        Node fast = head;
        for(int i=0; i<n; i++){
            fast = fast.next;
        }
        if(fast == null) { // n==len => I have to delete the head
            return head.next;
        }
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
//    private static Node removeNthFromEnd(Node head, int n) {
//        // find the len first
//        Node temp = head;
//        int len = 0;
//        while(temp != null){
//            len++;
//            temp = temp.next;
//        }
//        // n from end = len-n+1 from start
//        if(len == n) return head.next; // that means we have to delete the head
//        temp = head;
//        for(int i=0; i<len-n; i++){
//            temp = temp.next;
//        }
//        temp.next = temp.next.next;
//        return head;
//    }
}