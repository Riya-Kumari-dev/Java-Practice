package dsa.arrays.multidimensionalarray;

public class JaggedArray {
    static void main(String[] args) {
        int[][] arr = {{4,6,7},{7,8}}; // this is jagged array
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
