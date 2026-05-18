package dsa.collections.linkedlist;

import java.util.LinkedList;
import java.util.Scanner;

public class UserInput {
    static void main(String[] args) throws Exception{
        SinglyLinkedList l = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the linked list : ");
        int n = sc.nextInt();
        System.out.print("Enter "+n+" elements for the linked list : ");
        for(int i=0; i<n; i++){
            int val = sc.nextInt();
            l.add(i, val);
        }
        l.display();
        l.removeFromHead();
        l.display();
    }
}
