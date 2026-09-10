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

    // TC = O(vertex + 2*edges)
    // TC = O(n^2) (worst case)
    private static int findCircleNum(int[][] isConnected) {
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
    }
}