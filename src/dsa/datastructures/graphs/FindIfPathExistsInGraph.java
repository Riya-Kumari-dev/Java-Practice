package dsa.datastructures.graphs;

import java.util.*;

public class FindIfPathExistsInGraph {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices : ");
        int n = sc.nextInt();
        System.out.print("Enter the number of edges : ");
        int m = sc.nextInt();
        int[][] edges = new int[m][m];
        System.out.println("Enter the bidirectional edges : ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                edges[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter the starting point : ");
        int source = sc.nextInt();
        System.out.print("Enter the destination point : ");
        int destination = sc.nextInt();
        if(validPath(n, edges, source, destination)) System.out.println("Yes, we can reach from "+source+" to "+destination);
        else System.out.println("No, we cannot reach from "+source+" to "+destination);
    }

    // TS =  O(Vertex + 2*edges)
    // AS = O(Vertex + 2*edges)
    private static boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] isVisited = new boolean[n];
        dfs(isVisited, adj, source, destination);
        return isVisited[destination];
    }

    private static void dfs(boolean[] isVisited, List<List<Integer>> adj, int source, int destination) {
        isVisited[source] = true;
        for(int vertex : adj.get(source)){
            if(!isVisited[vertex]) {
                dfs(isVisited, adj, vertex, destination);
                if(vertex == destination) return;
            }
        }
    }

    private static void bfs(boolean[] isVisited, List<List<Integer>> adj, int source, int destination) {
        isVisited[source] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while(!q.isEmpty()) {
            int front = q.remove();
            for (int vertex : adj.get(front)) {
                if (!isVisited[vertex]) {
                    q.add(vertex);
                    isVisited[vertex] = true;
                    if (vertex == destination) return;
                }
            }
        }
    }
}