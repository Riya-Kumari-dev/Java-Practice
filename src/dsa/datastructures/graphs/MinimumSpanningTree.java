package dsa.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimsAlgorithm {
    /*Given a weighted, undirected, and connected graph with V vertices and a 2D array edges[][],
     where each element edges[i] = [u, v, w] represents an edge between vertices u and v with weight w,
    return the sum of the weights of all edges in the graph's Minimum Spanning Tree (MST).*/

    /*A Minimum Spanning Tree (MST) :
    a subset of edges from a connected, weighted, and undirected graph that connects all the vertices together without any cycles while achieving the minimum possible total edge weight*/

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices : ");
        int n = sc.nextInt();
        System.out.print("Enter the number of edges : ");
        int e = sc.nextInt();
        int[][] edges = new int[e][3];
        System.out.println("Enter the bidirectional edges and the weight between them : ");
        for (int i = 0; i < e; i++) {
            for (int j = 0; j < 3; j++) {
                edges[i][j] = sc.nextInt();
            }
        }
        System.out.println("Sum of the weights of all edges in the given graph's Minimum Spanning Tree is "+spanningTree(n, edges));
    }
    static class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    static class Triplet implements Comparable<Triplet> {
        int node;
        int parent;
        int weight;
        Triplet(int node, int parent, int weight){
            this.node = node;
            this.parent = parent;
            this.weight = weight;
        }
        public int compareTo(Triplet t){
            if(this.weight == t.weight) return Integer.compare(this.node, t.node);
            return Integer.compare(this.weight, t.weight);
        }
    }
    public static int spanningTree(int n, int[][] edges) {
        // create adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }
        // prim's algorithm
        boolean[] isVisited = new boolean[n];
        ArrayList<Triplet> ans = new ArrayList<>();
        int sum = 0;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0,-1,0));
        while(!pq.isEmpty()){
            Triplet top = pq.remove();
            if(isVisited[top.node]) continue;
            isVisited[top.node] = true;
            if(top.parent != -1){
                sum += top.weight;
                ans.add(top);
            }
            for(Pair p : adj.get(top.node)){
                int ele = p.node;
                if(!isVisited[ele]){
                    pq.add(new Triplet(ele, top.node, p.weight));
                }
            }
        }
        System.out.print("[");
        for (int i=0; i<ans.size(); i++) {
            Triplet t = ans.get(i);
            System.out.print("[" +t.node+","+t.parent+","+t.weight+"]");
            if(i!=ans.size()-1) System.out.print(",");
        }
        System.out.println("]");

        return sum;
    }
}