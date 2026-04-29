package dsa.arrays.multidimensionalarray;

import java.util.Scanner;

public class Sum {
    static void main(String[] args) {
        int[][] arr = {{2,3,4}, {6,5,4}};
        int sum = 0;
        for(int[] row : arr){
            for(int ele : row) {
                sum += ele;
            }
        }
        System.out.print("Sum of all the elements of the given matrix is : "+sum);
    }
}
