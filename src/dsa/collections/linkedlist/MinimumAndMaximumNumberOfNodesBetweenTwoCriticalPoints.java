package dsa.collections.linkedlist;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumAndMaximumNumberOfNodesBetweenTwoCriticalPoints {
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
        int[] ans = nodesBetweenCriticalPoints(l.getHead());
        System.out.print(Arrays.toString(ans));

    }
    private static int[] nodesBetweenCriticalPoints(Node head) {
        int[] ans = {-1,-1};
        Node left = head;
        Node mid = head.next;
        Node right = mid.next;
        if(right == null) return ans; // only 2 nodes present so no critical points
        int fidx = -1;
        int lidx = -1;
        int i = 1;
        int dis = -1;
        int minDis = Integer.MAX_VALUE;
        while(right!=null){
            // checking for critical points
            if((mid.val < left.val && mid.val < right.val) || (mid.val > left.val && mid.val > right.val)){
                if(fidx == -1) fidx = i; // first critical point marked
                if(lidx != -1){
                    // calculate the dis and update minDis
                    dis = i-lidx;
                    minDis = Math.min(minDis, dis);
                }
                lidx = i;
            }
            i++;
            left = left.next;
            mid = mid.next;
            right = right.next;
        }
        int maxDis = lidx-fidx;
        if(maxDis == 0) maxDis = -1; // same or no critical point
        if(minDis == Integer.MAX_VALUE) minDis = -1; // no critical point
        ans[0] = minDis;
        ans[1] = maxDis;
        return ans;
    }
}