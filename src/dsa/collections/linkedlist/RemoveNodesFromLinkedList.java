package dsa.collections.linkedlist;

import java.util.Scanner;

import static dsa.collections.linkedlist.ReverseLinkedList.reverse;

public class RemoveNodesFromLinkedList {
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
        Node newHead = removeNodes(l.getHead());
        l.setHead(newHead);
        l.display();
    }

    private static Node removeNodes(Node head) {
        head = reverse(head);
        Node i = head;
        Node j = head;
        if(head.next !=null) j = head.next;
        while(j!=null){
            while(j!=null && j.val < i.val) j = j.next;
            i.next = j;
            i = i.next;
            if(j!=null) j = j.next;
        }
        head = reverse(head);
        return head;
    }
}