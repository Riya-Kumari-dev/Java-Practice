package dsa.datastructures.graphs;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class NumberOfIslands {
    /*Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water),
     return the number of islands.
     An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     You may assume all four edges of the grid are all surrounded by water.*/

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the grid : ");
        int m = sc.nextInt();
        System.out.print("Enter the number of columns in the grid : ");
        int n = sc.nextInt();
        char[][] grid = new char[m][n];
        System.out.println("For land, enter 1 and for water enter 0 : ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        System.out.println("Number of islands in the given grid are "+numIslands(grid));
    }

    static class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    // AS = O(m*n), TC = O(m*n)
    private static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for(int j=0; j<n; j++){
                if (!isVisited[i][j] && grid[i][j] == '1') {
                   // bfs(i, j, isVisited, grid);
                    dfs(i, j, isVisited, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int i, int j, boolean[][] isVisited, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        isVisited[i][j] = true;
        // left
        if(j-1 >= 0 && !isVisited[i][j-1] && grid[i][j-1] == '1') dfs(i, j-1, isVisited, grid);
        // right
        if(j+1 < n && !isVisited[i][j+1] && grid[i][j+1] == '1') dfs(i, j+1, isVisited, grid);
        // down
        if(i+1 < m && !isVisited[i+1][j] && grid[i+1][j] == '1') dfs(i+1, j, isVisited, grid);
        // up
        if(i-1 >=0 && !isVisited[i-1][j] && grid[i-1][j] == '1') dfs(i-1, j, isVisited, grid);
    }

    private static void bfs(int i, int j, boolean[][] isVisited, char[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        q.add(new Pair(i, j));
        isVisited[i][j] = true;
        while(!q.isEmpty()){
            Pair front = q.remove();
            int r = front.row;
            int c = front.col;
            // left
            if(c-1 >= 0 && !isVisited[r][c-1] && grid[r][c-1] == '1'){
                q.add(new Pair(r, c-1));
                isVisited[r][c-1] = true;
            }
            // right
            if(c+1 < n && !isVisited[r][c+1] && grid[r][c+1] == '1'){
                q.add(new Pair(r, c+1));
                isVisited[r][c+1] = true;
            }
            // down
            if(r+1 < m && !isVisited[r+1][c] && grid[r+1][c] == '1'){
                q.add(new Pair(r+1, c));
                isVisited[r+1][c] = true;
            }
            // up
            if(r-1 >=0 && !isVisited[r-1][c] && grid[r-1][c] == '1'){
                q.add(new Pair(r-1, c));
                isVisited[r-1][c] = true;
            }
        }
    }
}