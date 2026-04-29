package dsa.arrays.multidimensionalarray;

public class TransposeOfMatrix {
    static void main(String[] args) {
        int[][] arr = {{2, 8, 3, 4}, {7, 2, 1, 6}, {5, 5, 4, 1}, {3, 1, 8, 2}};
        print(arr);
        System.out.println("Transpose of the given matrix : ");
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        print(arr);

    }
    static void print(int[][] arr){
        for(int[] row : arr){
            for(int ele : row) {
                System.out.print(ele+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
