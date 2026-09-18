package dsa.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static dsa.datastructures.graphs.DijkstraAlgorithm.dijkstraAlgo;

public class NetworkDelayTime {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices : ");
        int n = sc.nextInt();
        System.out.print("Enter the number of edges : ");
        int m = sc.nextInt();
        int[][] times = new int[m][3];
        System.out.println("Enter the bidirectional times and the network time between them : ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                times[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter the source vertex : ");
        int src = sc.nextInt();
        System.out.println("Minimum time to reach network to all the vertices from "+src+" is "+networkDelayTime(n, times, src));
    }
    private static int networkDelayTime(int n, int[][] times, int src) {
        // create adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : times) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2])); // as it is directional
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i<=n; i++) {
            ans.add(Integer.MAX_VALUE);
        }
        dijkstraAlgo(adj, src, ans);
        int max = -1;
        for(int i=1; i<=n; i++){
            if(ans.get(i) == Integer.MAX_VALUE) return -1;
            max = Math.max(max,ans.get(i));
        }
        return max;
    }
}