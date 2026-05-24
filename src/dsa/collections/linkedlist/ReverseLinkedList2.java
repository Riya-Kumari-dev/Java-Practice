package dsa.collections.linkedlist;

import java.util.Scanner;

import static dsa.collections.linkedlist.ReverseLinkedList.reverse;

public class ReverseLinkedList2 {
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
        System.out.println("1 based indexing ");
        System.out.print("Enter the starting index : ");
        int lo = sc.nextInt();
        System.out.print("Enter the ending index : ");
        int hi = sc.nextInt();
        l.display();
        Node newHead = reverseBetween(l.getHead(), lo , hi);
        l.setHead(newHead);
        l.display();
    }

    private static Node reverseBetween(Node head, int lo, int hi) {
        Node temp = head;
        Node a = null; // for lo-1
        Node b = null; // lo
        Node c = null; // hi
        Node d = null; // hi+1
        int i=1;
        // first mark the breakpoints
        while(temp!=null){
            if(i==lo-1) a = temp;
            if(i==lo) b = temp;
            if(i==hi) c = temp;
            if(i==hi+1) d = temp;
            temp = temp.next;
            i++;
        }
        // separate the list
        if(a!=null) a.next = null;
        c.next = null;
        // reverse between lo and hi
        c = reverse(b);
        // now add the lists
        if(a!=null) a.next = c;
        b.next = d;
        if(a==null) return c; // no a part present
        return head;
    }
}