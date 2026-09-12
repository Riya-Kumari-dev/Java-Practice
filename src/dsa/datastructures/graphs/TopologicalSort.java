package dsa.datastructures.graphs;

import java.util.*;

public class TopologicalSort {
    /*A topological ordering is a linear ordering of the vertices such that for every directed edge u -> v,
    vertex u appears before vertex v in the ordering.
    can be applied on directed acyclic graph only.*/
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
        System.out.println("Topological sort of the given graph : "+topoSort(n,edges));
    }

    // BFS (Kahn's Algorithm)
    private static ArrayList<Integer> topoSort(int n, int[][] edges) {
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
        return ans;

    }
    public static void bfs(int[] inDegree, List<List<Integer>> adj, ArrayList<Integer> ans){
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int front = q.remove();
            ans.add(front);
            for(int ele : adj.get(front)){
                inDegree[ele]--;
                if(inDegree[ele] == 0){
                    q.add(ele);
                }
            }
        }
    }

    // DFS
//    private static ArrayList<Integer> topoSort(int n, int[][] edges) {
//        List<List<Integer>> adj = new ArrayList<>();
//        for (int i = 0; i<n; i++) {
//            adj.add(new ArrayList<>());
//        }
//        for (int[] edge : edges) {
//            adj.get(edge[0]).add(edge[1]); // directed graph
//        }
//        boolean[] isVisited = new boolean[n];
//        ArrayList<Integer> ans = new ArrayList<>();
//        for(int i=0;i<n; i++){
//            if(!isVisited[i]){
//                dfs(i, isVisited, adj, ans);
//            }
//        }
//        Collections.reverse(ans);
//        return ans;
//
//    }
//    private static void dfs(int i, boolean[] isVisited, List<List<Integer>> adj, ArrayList<Integer> ans){
//        isVisited[i] = true;
//        for(int ele : adj.get(i)){
//            if(!isVisited[ele]) {
//                dfs(ele, isVisited, adj, ans);
//            }
//        }
//        ans.add(i);
//    }
}