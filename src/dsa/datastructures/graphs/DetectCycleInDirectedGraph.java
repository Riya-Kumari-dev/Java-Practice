package dsa.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static dsa.datastructures.graphs.TopologicalSort.bfs;

public class DetectCycleInDirectedGraph {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices : ");
        int n = sc.nextInt();
        System.out.print("Enter the number of edges : ");
        int m = sc.nextInt();
        int[][] edges = new int[m][2];
        System.out.println("Enter the unidirectional edges : ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                edges[i][j] = sc.nextInt();
            }
        }
        if(isCyclic(n, edges)) System.out.println("Yes, the given graph is cyclic.");
        else System.out.println("No, the given graph is not cyclic.");
    }

    private static boolean isCyclic(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]); // directed graph
        }
        int[] inDegree = new int[n];
        for(int i=0; i<n; i++){
            for(int ele : adj.get(i)){
                inDegree[ele]++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        bfs(inDegree, adj, ans);
        return ans.size() != n;
    }
}