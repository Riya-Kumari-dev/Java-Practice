package dsa.datastructures.graphs;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PathWithMinimumEffort {
    /*You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns,
     where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and
     you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right,
     and you wish to find a route that requires the minimum effort.

    `A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

    Return` the minimum effort required to travel from the top-left cell to the bottom-right cell.

*/
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the grid : ");
        int m = sc.nextInt();
        System.out.print("Enter the number of columns in the grid : ");
        int n = sc.nextInt();
        int[][] heights = new int[m][n];
        System.out.println("Enter the heights of the building : ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[i][j] = sc.nextInt();
            }
        }
        System.out.println("Minimum effort required to travel from the top-left cell to the bottom-right cell in the given grid is "+minimumEffortPath(heights));
    }
    static class Triplet implements Comparable<Triplet> {
        int row;
        int col;
        int effort;

        Triplet(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }

        public int compareTo(Triplet t) {
            if(t.effort == this.effort) return Integer.compare(this.col, t.col);
            return Integer.compare(this.effort, t.effort);
        }
    }

    private static int minimumEffortPath(int[][] heights) {
        int m = heights.length; // row
        int n = heights[0].length; // col
        int[][] eff = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(eff[i], Integer.MAX_VALUE);
        }

        // dijkstra
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0, 0, 0));
        eff[0][0] = 0;
        int[] r = {-1, 0, 1, 0};
        int[] c = {0, -1, 0, 1};
        while (!pq.isEmpty()) {
            Triplet top = pq.remove();
            int row = top.row;
            int col = top.col;
            if (top.effort > eff[row][col]) // the next effort coming is greater than prev one so ignore
                continue;
            for(int i=0; i<4; i++){
                int newRow = row + r[i];
                int newCol = col + c[i];
                if(newRow <0 || newCol < 0 || newRow >= m || newCol >= n) continue;
                int newEffort = Math.max(top.effort, Math.abs(heights[newRow][newCol] - heights[row][col]));
                if (newEffort < eff[newRow][newCol]) {
                    eff[newRow][newCol] = newEffort;
                    pq.add(new Triplet(newRow, newCol, newEffort));
                }
            }
        }
        return eff[m - 1][n - 1];
    }
}