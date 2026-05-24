package dsa.collections.linkedlist;

import java.util.Scanner;

import static dsa.collections.linkedlist.ReverseLinkedList.reverse;

public class ReorderList {
    static void main(String[] args) {
        SinglyLinkedList l = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the linked list : ");
        int n = sc.nextInt();
        System.out.print("Enter " + n + " elements for the linked list : ");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            try {
                l.add(i, val);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        l.display();
        Node newHead = reorderList(l.getHead());
        l.setHead(newHead);
        l.display();
    }

    private static Node reorderList(Node head) {
        // find the right middle node
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // now reverse the second half of the list from right middle node
        Node rev = reverse(slow);
        // now make alternate connections first - last - second - second last -- and so on
        Node temp = head;
        Node a = null; // for temp.next
        Node b = null; // for rev.next;
        while(rev.next!=null){
            a = temp.next;
            temp.next = rev;
            b = rev.next;
            rev.next = a;
            temp = a;
            rev = b;
        }
        return head;
    }
}