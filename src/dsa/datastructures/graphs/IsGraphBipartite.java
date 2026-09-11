package dsa.datastructures.graphs;

import java.util.*;

public class IsGraphBipartite {
    /*There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1.
    * A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that
    *  every edge in the graph connects a node in set A and a node in set B.
     */
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices : ");
        int n = sc.nextInt();
        int[][] graph = new int[n][];
        for (int i = 0; i < n; i++) {
            System.out.print("Number of edges going from " + i + "th vertex are ");
            int k = sc.nextInt();
            graph[i] = new int[k];
            System.out.print("Connected vertices to the "+i+"th vertex are : ");
            for (int j = 0; j < k; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        if(isBipartite(graph)) System.out.println("Yes, the given graph is bipartite.");
        else System.out.println("No, the given graph is not bipartite.");
    }

    private static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] isColoured = new int[n];
        Arrays.fill(isColoured, -1); // -1 mean not coloured
        for (int i = 0; i < n; i++) {
            if (isColoured[i] == -1) {
                // if(!bfs(i, isColoured, graph)) return false;

                // for dfs 👇 two lines
                isColoured[i] = 0; // only for new component
                if(dfs(i, isColoured, graph)) return false;
            }
        }
        return true;
    }

    private static boolean dfs(int i, int[] isColoured, int[][] graph) {
        for(int ele : graph[i]){
            if(isColoured[ele] == isColoured[i]) return false;
            if(isColoured[ele] == -1){
                isColoured[ele] = ((isColoured[i] == 0) ? 1 : 0);
                if(!dfs(ele, isColoured, graph)) return false;
            }
        }
        return true;
    }

    private static boolean bfs(int i, int[] isColoured, int[][] graph) {
        isColoured[i] = 0; // 0 means red and 1 means blue
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()){
            int front = q.remove();
            for(int ele : graph[front]){
                if(isColoured[ele] == isColoured[front]) return false;
                if(isColoured[ele] == -1){
                    q.add(ele);
                    isColoured[ele] = ((isColoured[front] == 0) ? 1 : 0);
                }

            }
        }
        return true;
    }
}