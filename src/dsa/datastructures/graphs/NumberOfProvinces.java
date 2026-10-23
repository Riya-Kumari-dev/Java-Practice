package dsa.datastructures.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumberOfProvinces {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of nodes : ");
        int n = sc.nextInt();
        int[][] isConnected = new int[n][n];
        System.out.println("If connected to each other enter 1 else 0 ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                isConnected[i][j] = sc.nextInt();
            }
        }

        System.out.println("Total number of provinces in the given graph is " + findCircleNum(isConnected));
    }

    // using DSU (Disjoint Set Union)
    // overall , TC = O(n^2 * alpha(n)) => TC = O(n^2)
    public static int leader(int a) { // // TC = O(alpha(n))
        if (parent[a] == a)
            return a;
        return parent[a] = leader(parent[a]); // path compression
    }
    /*public static int leader(int a) {
        if (parent[a] == a)
            return a;
        return leader(parent[a]);
    }*/

    // union by size
    public static void union(int a, int b) {
        int leaderA = leader(a);
        int leaderB = leader(b);
        if (leaderA != leaderB) {
            if (size[leaderA] > size[leaderB]) {
                parent[leaderA] = leaderB;
                size[leaderA] += size[leaderB];
            } else {
                parent[leaderB] = leaderA;
                size[leaderB] += size[leaderA];
            }
        }
    }

    static int[] parent;
    static int[] size;

    private static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) { // undirected graph, so from i+1 avoids duplicate connections and diagonal
                // edges is from i+1 to j+1
                if (i != j && isConnected[i][j] == 1) {
                    union(i + 1, j + 1);
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (parent[i] == i)
                count++;
        }
        return count;
    }

    // TC = O(n^3)
    /*public static int leader(int a){
        if(parent[a] == a) return a;
        return leader(parent[a]);
    }
    private static void union(int a, int b){
        int leaderA = leader(a);
        int leaderB = leader(b);
        if(leaderA != leaderB){
            parent[leaderA] = leaderB;
        }
    }
    static int[] parent;
    private static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                // edges is from i+1 to j+1
                if(i!=j && isConnected[i][j] == 1) {
                    union(i+1, j+1);
                }
            }
        }
        int count = 0;
        for(int i=1; i<=n; i++){
            if(parent[i] == i) count++;
        }
        return count;
    }*/

    // TC = O(vertex + 2*edges)
    // TC = O(n^2) (worst case)
    /*private static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
//                bfs(i, isVisited, isConnected);
                dfs(i, isVisited, isConnected);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int i, boolean[] isVisited, int[][] isConnected) {
        isVisited[i] = true;
        int n = isConnected.length;
        for (int j = 0; j < n; j++) {
            if (!isVisited[j] && isConnected[i][j] == 1) {
                dfs(j, isVisited, isConnected);
                isVisited[j] = true;
            }
        }
    }

    public static void bfs(int i, boolean[] isVisited, int[][] isConnected) {
        isVisited[i] = true;
        int n = isConnected.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while (!q.isEmpty()) {
            int front = q.remove();
            // add the connected components of front to the queue
            for (int j = 0; j < n; j++) {
                if (!isVisited[j] && isConnected[front][j] == 1) {
                    q.add(j);
                    isVisited[j] = true;
                }
            }
        }
    }*/
}