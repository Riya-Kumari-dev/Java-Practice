package dsa.datastructures.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

import static dsa.datastructures.graphs.NumberOfProvinces.leader;
import static dsa.datastructures.graphs.NumberOfProvinces.union;

public class MinCostToConnectAllPoints {
    /*The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them:
    |xi - xj| + |yi - yj|,  where |val| denotes the absolute value of val.
    Return the minimum cost to make all points connected.
    All points are connected if there is exactly one simple path between any two points.
 */
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total number of points : ");
        int n = sc.nextInt();
        int[][] points = new int[n][2];
        for(int i=0; i<n; i++){
            System.out.print("Enter the x coordinate for " + i + "th point : ");
            points[i][0] = sc.nextInt();
            System.out.print("Enter the y coordinate for " + i + "th point : ");
            points[i][1] = sc.nextInt();
        }
        System.out.println("Minimum cost to make all points connected is "+minCostConnectPoints(points));
    }

    // using Kruskal’s Algorithm using DSU
    // TC = O(n^2 *(log(n))
    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int dist;
        Edge(int u, int v, int dist){
            this.u= u;
            this.v = v;
            this.dist = dist;
        }
        public int compareTo(Edge t){
            if(this.dist == t.dist) return Integer.compare(this.u, t.u);
            return Integer.compare(this.dist, t.dist);
        }
    }
    static int[] parent;
    static int[] size;

    private static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        ArrayList<Edge> list = new ArrayList<>();
        for (int u=0; u<n; u++) {

            int x1 = points[u][0];
            int y1 = points[u][1];

            for(int v = u+1; v<n; v++){
                int x2 = points[v][0];
                int y2 = points[v][1];
                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
                list.add(new Edge(u, v, dist));
            }
        }
        Collections.sort(list);
        int minCost = 0;
        for(int i=0; i<list.size(); i++){
            Edge top = list.get(i);
            int u = top.u, v = top.v, dist = top.dist;
            if(leader(u) != leader(v)){
                union(u, v);
                minCost += dist;
            }
        }
        return minCost;
    }

    // using Prim's algorithm
    /*static class Triplet implements Comparable<Triplet> {
        int idx;
        int parent;
        int dist;
        Triplet(int idx, int parent, int dist){
            this.idx = idx;
            this.parent = parent;
            this.dist = dist;
        }
        public int compareTo(Triplet t){
            if(this.dist == t.dist) return Integer.compare(this.idx, t.idx);
            return Integer.compare(this.dist, t.dist);
        }
    }
    private static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        // prim's algorithm
        boolean[] isVisited = new boolean[n];
        int sum = 0;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0,-1,0));
        while(!pq.isEmpty()){
            Triplet top = pq.remove();
            int idx = top.idx;
            if(isVisited[idx]) continue;
            isVisited[idx] = true;
            if(top.parent != -1){
                sum += top.dist;
            }
            for(int i=0; i<n; i++){
                if(i == idx || i==top.parent || isVisited[i]) continue;
                int x1 = points[idx][0];
                int y1 = points[idx][1];
                int x2 = points[i][0];
                int y2 = points[i][1];
                int mDis = Math.abs(x2-x1)+Math.abs(y2-y1);
                pq.add(new Triplet(i, idx, mDis));
            }
        }
        return sum;
    }*/
}