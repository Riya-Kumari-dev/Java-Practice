package dsa.arrays.multidimensionalarray;

public class RowWithMaximumSum {
    static void main(String[] args) {
        int[][] arr = {{2,3,4}, {6,5,4}};
        int mxSum = Integer.MIN_VALUE;
        int idx = -1;
        for(int i=0; i<arr.length; i++){
            int sum = 0;
            for(int j=0; j<arr[0].length; j++) {
                sum += arr[i][j];
            }
            if(sum>mxSum){
                mxSum = sum;
                idx = i;
            }
        }
        System.out.print("Index having maximum sum  "+idx);
    }
}
