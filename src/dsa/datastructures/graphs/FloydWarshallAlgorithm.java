package dsa.datastructures.graphs;

import java.util.Scanner;

public class FloydWarshallAlgorithm {
    /*Given a weighted directed graph, represented by an adjacency matrix dist[][] of size n x n,
     where dist[i][j] represents the weight of the edge from node i to node j. If there is no direct edge,
     dist[i][j] is set to a large value (i.e., Integer.MAX_VALUE) to represent infinity.
    The graph may contain negative edge weights, but it does not contain any negative weight cycles.
    Find the shortest distance between every pair of nodes i and j in the graph.
    Note: Modify the distances for every pair in place.

    */
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices : ");
        int n = sc.nextInt();
        int[][] dist = new int[n][n];
        System.out.println("Fill the adjacency list , where dist[i][j] denotes the weight of the edge from node i to node j. If there is no direct edge, please enter  2147483647 : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = sc.nextInt();
            }
        }
        print(dist);
        floydWarshall(dist);
        print(dist);
    }

    public static void print(int[][] dist) {
        int m = dist.length;
        int n = dist[0].length;
        System.out.print("[");
        for(int i=0; i<n; i++){
            System.out.print("[");
            for(int j=0; j<n; j++){
                System.out.print(dist[i][j]);
                if(j<n-1) System.out.print(",");
            }
            System.out.print("]");
            if(i<n-1) System.out.print(",");
        }
        System.out.println("]");

    }

    public static void floydWarshall(int[][] dist) {
        int n = dist.length;
        for(int i=0; i<n; i++){ // pass through each node, via 0, then 1, then 2 .. and so on
            for(int row=0; row<n; row++){
                if(row == i) continue;
                for(int col=0; col<n; col++){
                    if(row == col || col == i || dist[row][i] == Integer.MAX_VALUE || dist[i][col] == Integer.MAX_VALUE)
                        continue;
                    dist[row][col] = Math.min(dist[row][col], (dist[row][i] + dist[i][col]));
                }
            }
        }
    }
}