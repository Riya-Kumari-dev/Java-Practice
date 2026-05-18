package dsa.collections.linkedlist;

import java.util.Scanner;

public class DeleteNodeInALinkedList {
    static void main(String[] args) throws Exception{
        // There is a singly-linked list, and we want to delete a node in it.
        //You are given the node to be deleted node. You will not be given access to the first node of head.
        SinglyLinkedList l = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the linked list : ");
        int n = sc.nextInt();
        System.out.print("Enter "+n+" elements for the linked list : ");
        for(int i=0; i<n; i++){
            int val = sc.nextInt();
            l.add(i, val);
        }
        System.out.print("Enter the index of the node to be deleted : ");
        int idx = sc.nextInt();
        Node target = l.getNode(idx);
        l.display();
        deleteNode(target);
        l.display();

    }

    private static void deleteNode(Node target) {
        target.val = target.next.val; // agle ka val copy kar do
        // aur agla node delete kar do jisko copy kiya gya tha
        target.next = target.next.next;
    }
}