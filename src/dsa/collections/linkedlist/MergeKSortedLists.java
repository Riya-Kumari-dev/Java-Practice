package dsa.collections.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MergeKSortedLists {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of lists : ");
        int n  = sc.nextInt();
        Node[] arr = new Node[n];
        for(int i=0; i<n; i++){
            SinglyLinkedList l = new SinglyLinkedList();
            System.out.print("Enter the size of the "+i+"th linked list : ");
            int m = sc.nextInt();
            System.out.print("Enter "+m+" elements for the "+i+"th linked list : ");
            for(int j=0; j<m; j++){
                int val = sc.nextInt();
                try{
                    l.add(j, val);
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
            arr[i] = l.getHead();
        }
        System.out.print("[");
        for(int i=0; i<arr.length; i++){
            display(arr[i]);
            if(i!=n-1) System.out.print(", ");
        }
        System.out.println("]");
        Node newHead = mergeKLists(arr);
        display(newHead);
    }
    private static Node merge(Node head, Node head1) {
        Node temp1 = head;
        Node temp2 = head1;
        Node dummy = new Node(-1);
        Node temp = dummy;
        while(temp1!= null && temp2!= null){
            if(temp1.val <= temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }
            else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp1!= null) temp.next = temp1;
        if(temp2 != null) temp.next = temp2;
        return dummy.next;
    }
    // TC = O(k*n*log(k))
    private static Node mergeKLists(Node[] arr) {
        if(arr.length == 1) return arr[0];
        // copying in arraylist
        ArrayList<Node> lists = new ArrayList<>(Arrays.asList(arr));

        while(lists.size()>1){
            ArrayList<Node> temp = new ArrayList<>();
            for(int i=0; i<lists.size(); i+=2){
                Node a = lists.get(i);
                Node b = null;
                if(i+1 < lists.size()) b = lists.get(i+1);
                if(b == null) temp.add(a);
                else temp.add(merge(a,b));
            }
            lists = temp; // saare temp wale lists me daal diye
        }
        return lists.getFirst();
    }
    // first approach
    // TC = O(n*k)
//    private static Node mergeKLists(Node[] arr) {
//        if(arr.length ==0) return null;
//        ArrayList<Node> ans = new ArrayList<>(Arrays.asList(arr));
//        while(ans.size()!=1){
//            ans.set(ans.size()-2, merge(ans.getLast(), ans.get(ans.size()-2)));
//            ans.removeLast();
//        }
//        return ans.getFirst();
//    }

    private static void display(Node head){
        Node temp = head;
        System.out.print("[");
        while(temp!=null){
            System.out.print(temp.val);
            if(temp.next!=null) System.out.print(", ");
            temp = temp.next;
        }
        System.out.print("]");
    }
}