package dsa.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Pair implements Comparable<Pair> {
    int val;
    int dist;
    Pair(int val, int dist) {
        this.val = val;
        this.dist = dist;
    }
    public int compareTo(Pair p) {
        return Integer.compare(this.dist, p.dist);
    }

}

public class DijkstraAlgorithm {
    /*Given an undirected, weighted graph with n vertices numbered from 0 to n-1 and E edges, represented by 2d array edges[][],
    where edges[i]=[u, v, w] represents the edge between the nodes u and v having w weight.
    Find the shortest distance of all the vertices from the source vertex src,
    and return an array of integers where the ith element denotes the shortest distance between ith node and source vertex src.*/

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices : ");
        int n = sc.nextInt();
        System.out.print("Enter the number of edges : ");
        int m = sc.nextInt();
        int[][] edges = new int[m][3];
        System.out.println("Enter the bidirectional edges and the distance between them : ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                edges[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter the source vertex : ");
        int src = sc.nextInt();
        System.out.println("Shortest distance of each ith vertex from "+src+" is "+dijkstra(n, edges, src));
    }
    private static ArrayList<Integer> dijkstra(int n, int[][] edges, int src) {
        // create adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            ans.add(Integer.MAX_VALUE);
        }
        dijkstraAlgo(adj, src, ans);
        return ans;
    }
    public static void dijkstraAlgo(List<List<Pair>> adj, int src, ArrayList<Integer> ans) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        ans.set(src, 0);
        while (!pq.isEmpty()) {
            Pair top = pq.remove(); // the min dist will come first
            if (top.dist > ans.get(top.val))
                continue;
            for (Pair p : adj.get(top.val)) {
                int ele = p.val;
                int dist = p.dist;
                int totalDist = dist + top.dist;
                if (totalDist < ans.get(ele)) {
                    ans.set(ele, totalDist);
                    pq.add(new Pair(ele, totalDist));
                }
            }
        }
    }
}