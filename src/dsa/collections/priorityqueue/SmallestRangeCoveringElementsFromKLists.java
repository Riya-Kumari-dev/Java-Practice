package dsa.collections.priorityqueue;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SmallestRangeCoveringElementsFromKLists {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows for the given matrix : ");
        int k = sc.nextInt();
        System.out.print("Enter number of columns for the given matrix : ");
        int n = sc.nextInt();
        int[][] arr = new int[k][n];
        System.out.print("Enter " + k * n + " elements for the matrix : ");
        for(int i=0; i<k; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.print("{");
        for(int i=0; i<k; i++){
            System.out.print("{");
            for(int j=0; j<n; j++){
                if(j!=0) System.out.print(",");
                System.out.print(arr[i][j]);
            }
            if(i<n-1) System.out.print("},");
            else System.out.print("}");
        }
        System.out.println("}");
        System.out.println("Smallest range : "+findSmallestRange(arr));
    }

    static class triplet implements Comparable<triplet> {
        int ele;
        int row;
        int col;

        triplet(int ele, int row, int col) {
            this.ele = ele;
            this.row = row;
            this.col = col;
        }

        public int compareTo(triplet t) {
            return Integer.compare(this.ele, t.ele);
        }
    }

    private static ArrayList<Integer> findSmallestRange(int[][] mat) {
        // code here
        PriorityQueue<triplet> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mat.length; i++) {
            triplet t = new triplet(mat[i][0], i, 0);
            pq.add(t);
            max = Math.max(max, mat[i][0]);
        }
        ArrayList<Integer> ans = new ArrayList<>(2);
        ans.add(pq.peek().ele);
        ans.add(max);
        int smallestRange = max - pq.peek().ele;
        while (pq.peek().col < mat[0].length - 1) {
            int j = pq.peek().col;
            int i = pq.remove().row;
            triplet t = new triplet(mat[i][j + 1], i, j + 1);
            pq.add(t);
            max = Math.max(mat[i][j + 1], max);
            int range = max - pq.peek().ele;
            if (range < smallestRange) {
                smallestRange = range;
                ans.set(0, pq.peek().ele);
                ans.set(1, max);
            }

        }
        return ans;

    }
}