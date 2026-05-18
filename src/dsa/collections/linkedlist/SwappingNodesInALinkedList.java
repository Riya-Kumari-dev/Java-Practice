package dsa.collections.linkedlist;

import java.util.Scanner;

public class SwappingNodesInALinkedList {
    static void main(String[] args) {
        SinglyLinkedList l = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the linked list : ");
        int m = sc.nextInt();
        System.out.print("Enter "+m+" elements for the linked list : ");
        for(int i=0; i<m; i++){
            int val = sc.nextInt();
            try{
                l.add(i, val);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        l.display();
        Node head2 = swapNthNode(l.getHead(), n);
        l.setHead(head2);
        l.display();
    }
    // we have to swap the data only not the node
    private static Node swapNthNode(Node head, int n) {
        // nth node from beginning
        Node begin = head;
        for(int i=1; i<n; i++){
            begin = begin.next;
        }
        // nth node from end
        Node slow = head;
        Node fast = head;
        for(int i=0; i<n; i++){
            fast = fast.next;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        Node end = slow;
        int temp = begin.val;
        begin.val = end.val;
        end.val = temp;
        return head;
    }
}
