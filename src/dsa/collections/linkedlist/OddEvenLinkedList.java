package dsa.collections.linkedlist;

import java.util.Scanner;

public class OddEvenLinkedList {
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
        Node newHead = oddEvenList(l.getHead());
        l.setHead(newHead);
        l.display();
    }
    // odd indices then even indices
    private static Node oddEvenList(Node head) {
        int i=1;
        Node  odd = new Node(-1);
        Node temp1 = odd;
        Node even = new Node(-2);
        Node temp2 = even;
        Node temp = head;
        while(temp!=null){
            if(i%2!=0) {
                temp1.next = temp;
                temp1 = temp1.next;
            }
            else{
                temp2.next = temp;
                temp2 = temp2.next;
            }
            temp = temp.next;
            i++;
        }
        if(temp2.next != null) temp2.next = null;
        temp1.next = even.next;
        return odd.next;
    }
}