package dsa.collections.linkedlist;

import java.util.Scanner;

public class RemoveDuplicateFromSortedList {
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
        removeDuplicates(l.getHead());
        l.display();
    }

    private static void removeDuplicates(Node head) {
        Node i = head;
        Node j = head;
        while(j!=null){
            while(j!=null && j.val == i.val) j = j.next;
            i.next = j;
            i = i.next;
        }
    }
}
