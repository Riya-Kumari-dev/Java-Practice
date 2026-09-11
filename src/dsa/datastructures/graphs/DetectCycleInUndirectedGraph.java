package dsa.datastructures.graphs;

import java.util.*;

public class DetectCycleInUndirectedGraph {
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
        if(isCycle(n, edges)) System.out.println("Yes, cycle exists.");
        else System.out.println("No, cycle doesn't exists.");
    }
    static class Pair {
        int parent;
        int child;
        Pair(int child, int parent) {
            this.child = child;
            this.parent = parent;
        }
    }
    private static boolean isCycle(int n, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i<n; i++) {
//            if (!isVisited[i] && dfs(i, -1, isVisited, adj))
//                return true;
            if (!isVisited[i] && bfs(i, isVisited, adj))
                return true;
        }
        return false;
    }
    private static boolean dfs(int node, int parent, boolean[] isVisited, List<List<Integer>> adj) {
        isVisited[node] = true;
        for (int ele : adj.get(node)) {
            if (isVisited[ele] && ele != parent)
                return true;
            if (!isVisited[ele] && ele != parent) {
                if (dfs(ele, node, isVisited, adj))
                    return true;
            }
        }
        return false;
    }
    private static boolean bfs(int start, boolean[] isVisited, List<List<Integer>> adj) {
        isVisited[start] = true;
        int n = adj.size();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, -1));
        while (!q.isEmpty()) {
            Pair front = q.remove();
            for(int ele : adj.get(front.child)){
                if(isVisited[ele] && ele != front.parent) return true;
                if(!isVisited[ele] && ele != front.parent){
                    q.add(new Pair(ele, front.child));
                    isVisited[ele] = true;
                }
            }
        }
        return false;
    }
}