package dsa.collections.priorityqueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KClosestPointsToOrigin {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of points : ");
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        System.out.println("Enter the coordinates :- ");
        for(int i=0; i<n; i++){
            System.out.print("x : ");
            arr[i][0] = sc.nextInt();
            System.out.print("y : ");
            arr[i][1] = sc.nextInt();
        }
        System.out.print("Enter the distance : ");
        int k = sc.nextInt();

        print(arr);
        System.out.println();
        int[][] ans = kClosest(arr, k);

        print(ans);
    }

    private static void print(int[][] arr) {
        int n = arr.length;
        System.out.print("{");
        for(int i=0; i<n; i++){
            System.out.print("{");
            for(int j=0; j<2; j++){
                if(j!=0) System.out.print(",");
                System.out.print(arr[i][j]);
            }
            if(i<n-1) System.out.print("},");
            else System.out.print("}");
        }
        System.out.println("}");
    }

    static class Pair implements Comparable<Pair>{
        int dis;
        int x;
        int y;
        Pair(int dis, int x, int y){
            this.dis = dis;
            this.x = x;
            this.y = y;
        }
        public int compareTo(Pair p){
            return Integer.compare(this.dis, p.dis);
        }
    }
    private static int[][] kClosest(int[][] arr, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int[] ele : arr){ // we can put the square also that one and the same thing
            int dis = (int)Math.pow(ele[0], 2) + (int)Math.pow(ele[1], 2);
            Pair p = new Pair(dis, ele[0], ele[1]);
            pq.add(p);
            if(pq.size()>k) pq.remove();
        }

        int[][] ans = new int[pq.size()][2];
        int i=0;
        while(!pq.isEmpty()){
            Pair top = pq.remove();
            ans[i][0] = top.x;
            ans[i][1] = top.y;
            i++;
        }
        return ans;
    }
}