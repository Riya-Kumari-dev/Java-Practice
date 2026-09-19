package dsa.datastructures.graphs;

import java.util.*;

public class PathWithMaximumProbability {
    /*You are given an undirected weighted graph of n nodes (0-indexed),
    represented by an edge list where edges[i] = [a, b] is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge succProb[i].
    Given two nodes start and end,
     find the path with the maximum probability of success to go from start to end and return its success probability.*/

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
        double[] succProb = new double[m];
        System.out.print("Enter the success probability for each edge : ");
        for(int i=0; i<m; i++){
            succProb[i] = sc.nextDouble();
        }
        System.out.print("Enter the start node : ");
        int start = sc.nextInt();
        System.out.print("Enter the end node : ");
        int end = sc.nextInt();
        System.out.println("The maximum probability for going from "+start+" to "+end+" is "+maxProbability(n, edges, succProb, start, end));
    }

    static class Pair implements Comparable<Pair> {
        int val;
        double prob;
        Pair(int val, double prob) {
            this.val = val;
            this.prob = prob;
        }
        public int compareTo(Pair p) {
            return Double.compare(this.prob, p.prob);
        }
    }

    private static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            adj.get(edge[0]).add(new Pair(edge[1], succProb[i]));
            adj.get(edge[1]).add(new Pair(edge[0], succProb[i]));
        }
        ArrayList<Double> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(0.0); // 0<= prob <= 1 , so minProb = 0
        }
        dijkstraAlgo(adj, start, ans);
        return ans.get(end);
    }

    private static void dijkstraAlgo(List<List<Pair>> adj, int start, ArrayList<Double> ans) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder()); // maxHeap
        pq.add(new Pair(start, 1)); // start par to already hai so probability to be there is 1
        ans.set(start, 1.0);
        while (!pq.isEmpty()) {
            Pair top = pq.remove();
            if (top.prob < ans.get(top.val))
                continue;
            for (Pair p : adj.get(top.val)) {
                int ele = p.val;
                double prob = p.prob;
                double totalProb = prob * top.prob; // probability is multiplicative in nature
                if (totalProb > ans.get(ele)) {
                    ans.set(ele, totalProb);
                    pq.add(new Pair(ele, totalProb));
                }
            }
        }
    }
}