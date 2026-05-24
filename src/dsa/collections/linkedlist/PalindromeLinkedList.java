package dsa.collections.linkedlist;

import java.util.Scanner;

import static dsa.collections.linkedlist.ReverseLinkedList.reverse;

public class PalindromeLinkedList {
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
        System.out.println(isPalindrome(l.getHead()));
    }

    private static boolean isPalindrome(Node head) {
        // find the left middle
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse the second part of the list
        Node right = reverse(slow.next);
        // now traverse through both the parts of the list if not equal return false;
        Node temp = head;
        while(right != null){
            if(right.val != temp.val) return false;
            right = right.next;
            temp = temp.next;
        }
        return true;
    }
}