package dsa.collections.linkedlist;

import java.util.Scanner;

import static dsa.collections.linkedlist.ReverseLinkedList.reverse;

public class MaximumTwinSumOfLinkedList {
    static void main(String[] args) {
        SinglyLinkedList l = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the even size of the linked list : ");
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
        System.out.println("Max Pair Sum : "+pairSum(l.getHead()));
    }
    // In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
    private static int pairSum(Node head) {
        // find the right middle
        Node slow = head;
        Node fast = head;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse the second part of the list
        Node right = reverse(slow);
        // now traverse through both the parts of the list and find the max pair sum
        Node temp = head;
        int max = Integer.MIN_VALUE;
        while(right != null){
            max = Math.max(right.val+temp.val, max);
            right = right.next;
            temp = temp.next;
        }
        return max;
    }
}