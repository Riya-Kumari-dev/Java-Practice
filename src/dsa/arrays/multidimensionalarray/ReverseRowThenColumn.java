package dsa.arrays.multidimensionalarray;

public class ReverseRowThenColumn {
    static void main(String[] args) {
        int[][] arr = {{2,8,3,4,7},{7,2,1,6,3},{5,5,4,1,4},{3,1,8,2,6}};
        print(arr);
        for(int[] ele : arr){ // reversed row wise
            reverse(ele);
        }
        for(int j=0; j<arr[0].length; j++){
            int i=0;
            int k = arr.length-1;
            while(i<k){
                int temp = arr[i][j];
                arr[i][j] = arr[k][j];
                arr[k][j] = temp;
                i++;
                k--;
            }
        }
        print(arr);
    }
    static void reverse(int[] arr){
        int i=0;
        int j = arr.length-1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
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
