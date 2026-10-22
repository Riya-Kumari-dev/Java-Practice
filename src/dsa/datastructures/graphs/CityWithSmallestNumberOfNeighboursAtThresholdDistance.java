package dsa.datastructures.graphs;

import java.util.Scanner;

import static dsa.datastructures.graphs.FloydWarshallAlgorithm.floydWarshall;

public class CityWithSmallestNumberOfNeighboursAtThresholdDistance {
    /*There are n cities numbered from 0 to n-1.
     Given the array edges where edges[i] = [from i, to i, weight i] represents a bidirectional and weighted edge between cities from i and to i, and given the integer distanceThreshold.
    Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold, 
    If there are multiple such cities, return the city with the greatest number.
    Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.*/
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices : ");
        int n = sc.nextInt();
        System.out.print("Enter the number of edges : ");
        int m = sc.nextInt();
        int[][] edges = new int[m][3];
        System.out.println("Enter the bidirectional edges and the distance between them : ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= 2; j++) {
                edges[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter the distance threshold : ");
        int distanceThreshold = sc.nextInt();
        System.out.println("City with the smallest number of cities that are reachable through some path and whose distance is at most "+distanceThreshold+" is "+findTheCity(n, edges, distanceThreshold));
    }

    private static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // form adjacency matrix
        int[][] dist = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                dist[i][j] = Integer.MAX_VALUE;
        }
        for(int[] edge : edges){
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }
        floydWarshall(dist);
        int minCity = -1;
        int minCount = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int count = 0; // from i to j where dis[i][j] <= threshold
            for(int j=0; j<n; j++){
                if(i==j) continue;
                if(dist[i][j] <= distanceThreshold){
                    count++;
                }
            }
            if(count<= minCount){
                minCount = count;
                minCity = i;
            }

        }
        return minCity;
    }
}