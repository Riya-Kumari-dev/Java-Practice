package dsa.arrays.multidimensionalarray;

public class DisplayColumnWise {
    static void main(String[] args) {
        int[][] arr = {{2,3,9}, {6,5,3},{5,5,2}, {0,1,10}};
        for(int j=0; j<arr[0].length; j++){
            for(int i=0; i<arr.length; i++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
