package dsa.collections.linkedlist;

import java.util.Scanner;

public class LinkedListCycle2 {
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
        Node cycle = detectCycle(l.getHead());
        if(cycle == null) System.out.println("No cycle in the given linked list");
        else System.out.println(cycle.val);
    }

    private static Node detectCycle(Node head) {
        Node slow = head;
        Node fast = head;
        if(head == null || head.next == null) return null;
        // first detect the loop
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(slow!=fast) return null; // no loop
        Node temp = head;
        while(temp!=slow){
            temp = temp.next;
            slow = slow.next;
        }
        return temp;
    }
    /* Mathematical proof for temp and slow
    n = total length
    m = cycle se last tak ka length
    x = distance where slow and fast met

                |-----m-------| // cycle length
                |---x-----|here slow and fast met
    |-----------n-------------|
    temp
      slow distance = n-m+x;
      fast distance = n+x;

      Ts = Tf
      (n-m+x)/1 = (n+x)/2; dis/speed
      2n - 2m + 2x = n+x;
      n+x = 2m
      x = 2m-n; // it is a linear relation

     // above was for the distance where slow and fast met
     // now why slow and temp met
     slow dist = m-x; => m-(2m-n) => n-m
     temp dist = n-m;
     hence proved
     */
}
