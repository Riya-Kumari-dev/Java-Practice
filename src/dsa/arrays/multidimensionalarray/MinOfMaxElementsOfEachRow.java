package dsa.arrays.multidimensionalarray;

public class MinOfMaxElementsOfEachRow {
    static void main(String[] args) {
        int[][] arr = {{2,3,4}, {6,5,4},{5,5,4}};
        int mn= Integer.MAX_VALUE;
        for(int[] row : arr){
            int Mx = Integer.MIN_VALUE;
            for(int ele : row) {
                Mx = Math.max(Mx, ele);
            }
            mn = Math.min(mn, Mx);
        }
        System.out.print("Minimum element out of all the maximum elements of each row is "+mn);
    }
}
