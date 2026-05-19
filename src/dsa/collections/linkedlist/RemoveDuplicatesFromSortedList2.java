package dsa.collections.linkedlist;

import java.util.Scanner;

public class RemoveDuplicatesFromSortedList2 {
    static void main(String[] args) {
        SinglyLinkedList l = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the linked list : ");
        int n = sc.nextInt();
        System.out.print("Enter "+n+" elements for the linked list in sorted order : ");
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
        Node newHead = removeDuplicates(l.getHead());
        l.setHead(newHead);
        l.display();
    }

    private static Node removeDuplicates(Node head) {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node j = head;
        Node i = dummy;
        Node temp = dummy;
        while(j!=null){
            if(j.next != null && j.val == j.next.val){
                int data = j.val;
                while(j!=null && j.val == data) j = j.next;
                i.next = j;
            }
            else{
                i = j;
                j = j.next;
            }

        }
        return dummy.next;
    }
}
