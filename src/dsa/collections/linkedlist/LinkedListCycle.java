package dsa.collections.linkedlist;

import java.util.Scanner;

public class LinkedListCycle {
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
        System.out.println(hasCycle(l.getHead()));
    }
    /* Mathematical proof
    n = total length
    m = cycle se last tak ka length
    x = distance where slow and fast met

                |-----m-------| // cycle length
                |---x-----|here slow and fast met
    |-----------n-------------|

      slow distance = n-m+x;
      fast distance = n+x;

      Ts = Tf
      (n-m+x)/1 = (n+x)/2; dis/speed
      2n - 2m + 2x = n+x;
      n+x = 2m
      x = 2m-n; // it is a linear relation
     */
    private static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
