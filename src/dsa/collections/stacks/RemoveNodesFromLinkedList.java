package dsa.collections.stacks;

import dsa.collections.linkedlist.Node;
import dsa.collections.linkedlist.SinglyLinkedList;

import java.util.Scanner;
import java.util.Stack;

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
        Stack<Integer> st = new Stack<>();
        Node temp = head;
        while(temp != null){
            while(!st.isEmpty() && st.peek() < temp.val){
                st.pop();
            }
            st.push(temp.val);
            temp = temp.next;
        }
        Node newHead = null;
        while(!st.isEmpty()){
            Node t = new Node(st.pop());
            t.next = newHead;
            newHead = t;
        }
        return newHead;
    }
}