package dsa.datastructures.graphs;

import java.util.*;

public class CheapestFlightsWithinKStops {
    /*There are n cities connected by some number of flights.
     You are given an array flights where flights[i] = [from i, to i, price i]
     indicates that there is a flight from city from i to city to i with cost price i.
    You are also given three integers src, dst, and k,
    return the cheapest price from src to dst with at most k stops.
    If there is no such route, return -1.*/

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of cities : ");
        int n = sc.nextInt();
        int[][] flights = new int[n][3];
        System.out.println("Enter their data : ");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the "+i+"th flight, their connecting flight and its cost : ");
            for (int j = 0; j < 3; j++) {
                flights[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter the starting point : ");
        int src = sc.nextInt();
        System.out.print("Enter the destination point : ");
        int dst = sc.nextInt();
        System.out.print("Enter the number of minimum stops you can take : ");
        int k = sc.nextInt();
        System.out.println("The cheapest price from "+src+" to "+dst+" is "+findCheapestPrice(n,flights, src, dst, k));
    }

    static class Pair{
        int val;
        int cost;
        Pair(int val, int cost){
            this.val = val;
            this.cost = cost;
        }
    }
    static class Triplet{
        int val;
        int cost;
        int stops;
        Triplet(int val, int cost, int stops){
            this.val = val;
            this.cost = cost;
            this.stops = stops;
        }
    }
    private static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // create adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : flights) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        // dijkstra using queue
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;
        Queue<Triplet> pq = new LinkedList<>();
        pq.add(new Triplet(src, 0,0));
        while(!pq.isEmpty()){
            Triplet top = pq.remove();
            if(top.stops == k+1) continue;
            for(Pair p : adj.get(top.val)){
                int totalCost = top.cost + p.cost;
                if(totalCost < ans[p.val]){
                    ans[p.val] = totalCost;
                    pq.add(new Triplet(p.val, totalCost, top.stops+1));
                }
            }
        }
        if(ans[dst] == Integer.MAX_VALUE) return -1;
        return ans[dst];
    }

//    static class Triplet implements Comparable<Triplet>{
//        int val;
//        int cost;
//        int stops;
//        Triplet(int val, int cost, int stops){
//            this.val = val;
//            this.cost = cost;
//            this.stops = stops;
//        }
//        public int compareTo(Triplet t){
//            if(this.stops == t.stops) return Integer.compare(this.cost, t.cost);
//            return Integer.compare(this.stops, t.stops);
//        }
//    }
//    private static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        // create adjacency list
//        List<List<Pair>> adj = new ArrayList<>();
//        for (int i = 0; i<n; i++) {
//            adj.add(new ArrayList<>());
//        }
//        for (int[] edge : flights) {
//            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
//        }
//
//        // dijkstra using priority queue
//        int[] ans = new int[n];
//        Arrays.fill(ans, Integer.MAX_VALUE);
//        ans[src] = 0;
//        PriorityQueue<Triplet> pq = new PriorityQueue<>();
//        pq.add(new Triplet(src, 0,0));
//        while(!pq.isEmpty()){
//            Triplet top = pq.remove();
//            if(top.stops == k+1) continue;
//            for(Pair p : adj.get(top.val)){
//                int totalCost = top.cost + p.cost;
//                if(totalCost < ans[p.val]){
//                    ans[p.val] = totalCost;
//                    pq.add(new Triplet(p.val, totalCost, top.stops+1));
//                }
//            }
//        }
//        if(ans[dst] == Integer.MAX_VALUE) return -1;
//        return ans[dst];
//    }
}