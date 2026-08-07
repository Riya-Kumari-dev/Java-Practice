package dsa.backtracking;

import java.util.Scanner;

public class RatInAMaze {
    // 4 directions
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows : ");
        int row = sc.nextInt();
        System.out.print("Enter the number of columns : ");
        int col = sc.nextInt();
        int ways = ratInMaz(row, col);
        System.out.println("Total ways are "+ways);
    }

    private static int ratInMaz(int row, int col) {
        boolean[][] visited = new boolean[row][col];
        return path(0, 0, row-1, col-1, "", visited);
    }

    private static int path(int sr, int sc, int er, int ec,String s, boolean[][] visited){
        if(sr>er || sc>ec || sr<0 || sc<0 || visited[sr][sc]) return 0;
        visited[sr][sc] = true;
        if(sr == er && sc == ec) {
            System.out.println(s);
            visited[sr][sc] = false; // backtracking
            return 1;
        }

        int right = path(sr, sc+1, er, ec,s+'R', visited);
        int left = path(sr, sc-1, er, ec, s+'L', visited);
        int up = path(sr-1, sc, er, ec, s+'U', visited);
        int down = path(sr+1, sc, er, ec, s+'D', visited);
        visited[sr][sc] = false; // backtracking
        return right + left + up + down;
    }

    // only 1 path because sare place pe true marked hai so cannot go to other way
//    private static int ratInMaz(int row, int col) {
//        boolean[][] visited = new boolean[row][col];
//        return path(0,0, row-1, col-1, "", visited);
//    }
//    private static int path(int sr, int sc, int er, int ec,String s, boolean[][] visited){
//        if(sr >er || sc >ec || sr <0 || sc <0 || visited[sr][sc]) return 0;
//        visited[sr][sc] = true;
//        if(sr == er && sc == ec) {
//            System.out.println(s);
//            return 1;
//        }
//
//        int right = path(sr, sc +1, er, ec,s+'R', visited);
//        int left = path(sr, sc -1, er, ec, s+'L', visited);
//        int up = path(sr -1, sc, er, ec, s+'U', visited);
//        int down = path(sr +1, sc, er, ec, s+'D', visited);
//        return right + left + up + down;
//    }

    // recursion infinite loop because of coming at the same place again and again so better to mark the visited place
//    private static int ratInMaz(int row, int col) {
//        return path(0,0, row-1, col-1, "");
//    }
//    private static int path(int sr, int sc, int er, int ec, String s){
//        if(sr >er || sc >ec || sr <0 || sc <0) return 0;
//        if(sr == er && sc == ec) {
//            System.out.println(s);
//            return 1;
//        }
//        int right = path(sr, sc +1, er, ec, s+'R');
//        int left = path(sr, sc -1, er, ec, s+'L');
//        int up = path(sr -1, sc, er, ec, s+'U');
//        int down = path(sr +1, sc, er, ec, s+'D');
//        return right + left + up + down;
//    }
}
