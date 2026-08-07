package dsa.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NQueens {
    // The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
    //Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
    //Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.'
    // both indicate a queen and an empty space, respectively.

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of queens to be placed : ");
        int n = sc.nextInt();
        System.out.println("All distinct solutions to arrange "+n+" queens on "+n+"*"+n+" chessboard is "+solveNQueen(n));
    }
    private static List<List<String>> solveNQueen(int n) {
        char[][] mark = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                mark[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        helper(0,n,ans,mark);
        return ans;
    }
    private static void helper(int row, int n, List<List<String>> ans , char[][] mark){
        if(row==n) {
            List<String> v = new ArrayList<>();
            for(int i=0; i<mark.length; i++){
                String t = "";
                for(int j=0; j<mark[0].length; j++){
                    char ch = mark[i][j];
                    t += ch;
                }
                v.add(t);
            }
            ans.add(v);
            return;
        }
        for(int col=0; col<n; col++){
            if(canQueenPlaced(mark,row, col)) {
                mark[row][col] = 'Q';
                helper(row+1, n, ans, mark);
                mark[row][col] = '.';
            }
        }
    }
    private static boolean canQueenPlaced(char[][] mark, int row, int col){
        // check col
        int i=row-1;
        while(i>=0){
            if(mark[i][col] != '.') return false;
            i--;
        }
        // check left diagonal
        i=row-1;
        int j=col-1;
        while(i>=0 && j>=0){
            if(mark[i][j] != '.') return false;
            i--;
            j--;
        }
        // check right diagonal
        i=row-1;
        j=col+1;
        while(i>=0 && j<mark.length){
            if(mark[i][j] != '.') return false;
            i--;
            j++;
        }
        return true;
    }
}
