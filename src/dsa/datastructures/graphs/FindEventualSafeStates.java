package dsa.datastructures.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static dsa.datastructures.graphs.TopologicalSort.bfs;

public class FindEventualSafeStates {
    /*There is a directed graph of n nodes with each node labeled from 0 to n - 1.
    The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i,
    meaning there is an edge from node i to each node in graph[i].

    A node is a terminal node if there are no outgoing edges.
    A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).
    Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.*/

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices : ");
        int n = sc.nextInt();
        int[][] graph = new int[n][];
        for (int i = 0; i < n; i++) {
            System.out.print("Number of outgoing edges in " + i + "th vertex is : ");
            int k = sc.nextInt();
            graph[i] = new int[k];
            if(k!= 0) System.out.print("Vertices connected to the "+i+"th vertex are : ");
            for (int j = 0; j < k; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        System.out.println("All the safe nodes of the given graph are "+eventualSafeNodes(graph));
    }

    private static ArrayList<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        // create a reverse graph
        // -> incoming nodes will be outgoing to that node
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for(int i=0; i<n; i++){
            for(int ele : graph[i]){
                // original : i -> ele
                // reverse : ele -> i
                adj.get(ele).add(i);
                inDegree[i]++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        // apply kahn's algorithm for outgoing edges
        bfs(inDegree, adj, ans);
        Collections.sort(ans);
        return ans;
    }
}