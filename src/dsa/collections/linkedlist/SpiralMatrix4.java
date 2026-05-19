package dsa.collections.linkedlist;

import java.util.Arrays;
import java.util.Scanner;

public class SpiralMatrix4 {
    static void main(String[] args) {
        SinglyLinkedList l = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the linked list : ");
        int n = sc.nextInt();
        System.out.print("Enter "+n+" elements for the linked list : ");
        for(int i=0; i<n; i++){
            int val = sc.nextInt();
            try{
                l.add(i, val);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.print("Enter the dimensions of 2D matrix : ");
        int m = sc.nextInt();
        int k = sc.nextInt();
        l.display();
        int[][] mat = spiralMatrix(m, k, l.getHead());
        for(int[] row : mat){
            for(int ele : row) System.out.print(ele+ " ");
            System.out.println();
        }
    }

    private static int[][] spiralMatrix(int m, int k, Node head) {
        int minRow = 0;
        int minCol = 0;
        int maxRow = m-1;
        int maxCol = k-1;
        int[][] mat = new int[m][k];
        for(int[] row : mat) Arrays.fill(row, -1);
        Node temp = head;
        while(minRow <= maxRow && minCol <= maxCol){
            for(int j=minCol; j<= maxCol; j++){
                if(temp == null) return mat;
                mat[minRow][j] = temp.val;
                temp = temp.next;
            }
            minRow++;
            for(int i=minRow; i<=maxRow; i++){
                if(temp == null) return mat;
                mat[i][maxCol] = temp.val;
                temp = temp.next;
            }
            maxCol--;
            for(int j=maxCol; j>= minCol; j--){
                if(temp == null) return mat;
                mat[maxRow][j] = temp.val;
                temp = temp.next;
            }
            maxRow--;
            for(int i=maxRow; i>=minRow; i--){
                if(temp == null) return mat;
                mat[i][minCol] = temp.val;
                temp = temp.next;
            }
            minCol++;
        }
        return mat;
    }
}
