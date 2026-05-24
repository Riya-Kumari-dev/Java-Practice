package dsa.collections.linkedlist;

import java.util.Scanner;

public class SplitLinkedListInParts {
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
        System.out.print("Enter the number of division, k : ");
        int k = sc.nextInt();
        l.display();
        Node[] ans = splitListToParts(l.getHead(), k);
        display(ans);
    }

    private static void display(Node[] ans) {
        System.out.print("[");
        for(int i=0; i<ans.length; i++){
            Node temp = ans[i];
            System.out.print("[");
            while(temp!=null){
                System.out.print(temp.val);
                if(temp.next!=null) System.out.print(", ");
                temp = temp.next;
            }
            if(i==ans.length-1) System.out.print("]");
            else System.out.print("],");
        }
        System.out.println("]");
    }

    private static Node[] splitListToParts(Node head, int k) {
        int n = length(head);
        int parts = n/k;
        int extra = n%k;
        Node[] ans = new Node[k];
        int idx = 0;
        Node temp = head;
        while(temp != null){
            Node dummy = new Node(-1);
            Node t = dummy;
            int i=1;
            while(i<=parts){
                t.next = temp;
                temp = temp.next;
                t = t.next;
                i++;
            }
            if(extra > 0){
                t.next = temp;
                temp = temp.next;
                t = t.next;
                extra--;
            }
            t.next = null;
            ans[idx] = dummy.next;
            idx++;
        }
        return ans;
    }

    private static int length(Node head) {
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }

}