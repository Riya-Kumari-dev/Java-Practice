package dsa.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BellmanFordAlgorithm {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices : ");
        int n = sc.nextInt();
        System.out.print("Enter the number of edges : ");
        int e = sc.nextInt();
        int[][] edges = new int[e][3];
        System.out.println("Enter the vertices between directional edges and the weight between them : ");
        for (int i = 0; i < e; i++) {
            for (int j = 0; j < 3; j++) {
                edges[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter the source : ");
        int src = sc.nextInt();
        System.out.println("Shortest distances from the src to all other vertices : "+bellmanFord(n, edges, src));
    }

    // Bellman Ford Algorithm :
    // TC = O(v*e)
    //  Unlike Dijkstra's algorithm, Bellman–Ford can safely handle negative edge weights
    private static ArrayList<Integer> bellmanFord(int n, int[][] edges, int src) {
        ArrayList<Integer> dist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dist.add(100000000);
        }
        dist.set(src, 0);
        // Relax all edges n-1 times
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int wt = edges[j][2];
                if (dist.get(u) != 100000000 && dist.get(u) + wt < dist.get(v)) {
                    dist.set(v, dist.get(u) + wt);
                }
            }
        }
        // Check for a negative-weight cycle
        for (int j = 0; j < edges.length; j++) {
            int u = edges[j][0];
            int v = edges[j][1];
            int wt = edges[j][2];
            if (dist.get(u) != 100000000 &&dist.get(u) + wt < dist.get(v)) {
                return new ArrayList<>(List.of(-1));
            }
        }
        return dist;
    }
}