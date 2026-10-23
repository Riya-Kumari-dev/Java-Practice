package dsa.datastructures.graphs;

import java.util.Arrays;
import java.util.Scanner;

import static dsa.datastructures.graphs.NumberOfProvinces.leader;
import static dsa.datastructures.graphs.NumberOfProvinces.union;

public class RedundantConnection {
    /*In this problem, a tree is an undirected graph that is connected and has no cycles.
    You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added.
     The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed.
      The graph is represented as an array edges of length n where edges[i] = [a i, b i] indicates that there is an edge between nodes a i and b i in the graph.
    Return an edge that can be removed so that the resulting graph is a tree of n nodes.
    If there are multiple answers, return the answer that occurs last in the input.

 */
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices : ");
        int n = sc.nextInt();
        System.out.print("Enter the number of edges : ");
        int m = sc.nextInt();
        int[][] edges = new int[m][2];
        System.out.println("Enter the bidirectional edges : ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                edges[i][j] = sc.nextInt();
            }
        }
        System.out.println("Edge that can be removed so that the resulting graph is a tree of n nodes is "+findRedundantConnection(edges).toString());
    }

    // TC = O(n*alpha(n)) ; TC = O(n)
    static int[] parent;
    static int[] size;
    private static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int[] ans = new int[2];
        Arrays.fill(ans, -1);
        for(int[] arr : edges){
            int u = arr[0];
            int v = arr[1];
            if(leader(u) == leader(v)){ // cycle detected
                ans[0] = u;
                ans[1] = v;
                return ans;
            }
            else union(u, v);
        }
        return ans;
    }
}