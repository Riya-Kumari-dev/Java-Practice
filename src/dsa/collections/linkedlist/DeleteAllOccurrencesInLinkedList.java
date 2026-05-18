package dsa.collections.linkedlist;

import java.util.Scanner;

public class DeleteAllOccurrencesInLinkedList {
    static void main(String[] args){
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
        Node head2 = deleteAllOccurrences(l.getHead(), x);
        l.setHead(head2);
        l.display();
    }

    private static Node deleteAllOccurrences(Node head, int x) {
        Node temp = head;
        while(temp!=null && temp.val == x){
            temp = temp.next;
        }
        head = temp;
        while(temp!= null && temp.next != null){
            if(temp.next.val == x){
                temp.next = temp.next.next;
            }
            else temp = temp.next;
        }
        return head;
    }
}