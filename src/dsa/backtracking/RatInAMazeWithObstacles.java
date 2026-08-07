package dsa.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RatInAMazeWithObstacles {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows : ");
        int row = sc.nextInt();
        System.out.print("Enter the number of columns : ");
        int col = sc.nextInt();
        int[][] maze = new int[row][col];
        System.out.println("For the open path enter 1 else 0 : ");
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                maze[i][j] = sc.nextInt();
            }
        }
        System.out.println("All the possible ways are "+ratInMaze(maze));
    }
    // AS = O(1)
    private static ArrayList<String> ratInMaze(int[][] maze) {
        int m = maze.length; int n = maze[0].length;
        ArrayList<String> ans = new ArrayList<>();
        path(0,0,m-1,n-1,"",maze,ans);
        Collections.sort(ans);
        return ans;
    }
    private static void path(int sr, int sc, int er, int ec,String s, int[][] maze, ArrayList<String> ans){
        if(sr >er || sc >ec || sr <0 || sc <0 || maze[sr][sc] == 0 || maze[sr][sc] == -1) return;
        maze[sr][sc] = -1; // -1 will denote that it is visited
        if(sr == er && sc == ec) {
            ans.add(s);
            maze[sr][sc] = 1; // backtracking
            return;
        }

        path(sr, sc +1, er, ec,s+'R', maze, ans);
        path(sr, sc -1, er, ec, s+'L', maze, ans);
        path(sr -1, sc, er, ec, s+'U', maze, ans);
        path(sr +1, sc, er, ec, s+'D', maze, ans);
        maze[sr][sc] = 1; // backtracking
    }

    // AS = O(row*col)
//    private static ArrayList<String> ratInMaze(int[][] maze) {
//        // code here
//        int m = maze.length; int n = maze[0].length;
//        boolean[][] visited = new boolean[m][n];
//        ArrayList<String> ans = new ArrayList<>();
//        path(0,0,m-1,n-1,"",visited,maze,ans);
//        Collections.sort(ans);
//        return ans;
//    }
//    private static void path(int sr, int sc, int er, int ec,String s, boolean[][] visited, int[][] maze, ArrayList<String> ans){
//        if(sr >er || sc >ec || sr <0 || sc <0 || visited[sr][sc] || maze[sr][sc] == 0) return;
//        visited[sr][sc] = true;
//        if(sr == er && sc == ec) {
//            ans.add(s);
//            visited[sr][sc] = false; // backtracking
//            return;
//        }
//
//        path(sr, sc +1, er, ec,s+'R', visited, maze, ans);
//        path(sr, sc -1, er, ec, s+'L', visited, maze, ans);
//        path(sr -1, sc, er, ec, s+'U', visited, maze, ans);
//        path(sr +1, sc, er, ec, s+'D', visited, maze, ans);
//        visited[sr][sc] = false; // backtracking
//    }
}
