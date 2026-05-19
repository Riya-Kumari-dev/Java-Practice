package dsa.collections.linkedlist;

import java.util.Scanner;

public class RotateList {
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
        System.out.print("Enter number of rotations : ");
        int k = sc.nextInt();
        l.display();
        Node head2 = rotate(l.getHead(), k);
        l.setHead(head2);
        l.display();
    }
    private static int length(Node head){
        Node temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }
    private static Node rotate(Node head, int k) {
        if(head == null || head.next==null) return head;
        int n = length(head);
        k = k%n;
        if(k==0) return head;
        Node slow = head;
        Node fast = head;
        for(int i=1; i<=k; i++){
            fast = fast.next;
        }
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        Node a = slow.next;
        Node temp = a;
        slow.next = null;
        while(temp.next!=null) temp = temp.next;
        temp.next = head;
        return a;
    }
}