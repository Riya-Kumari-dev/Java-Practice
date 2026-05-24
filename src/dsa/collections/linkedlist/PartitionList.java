package dsa.collections.linkedlist;

import java.util.Scanner;

public class PartitionList {
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
        System.out.print("Enter x : ");
        int x = sc.nextInt();
        l.display();
        Node newHead = partition(l.getHead(), x);
        l.setHead(newHead);
        l.display();
    }

    private static Node partition(Node head, int x) {
        Node left = new Node(-1);
        Node temp1 = left;
        Node right = new Node(-2);
        Node temp2 = right;
        Node temp = head;
        while(temp!=null){
            if(temp.val < x) {
                temp1.next = temp;
                temp1 = temp1.next;
            }
            else{
                temp2.next = temp;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp2.next != null) temp2.next = null;
        temp1.next = right.next;
        return left.next;
    }
}