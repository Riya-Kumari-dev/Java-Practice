package dsa.arrays.multidimensionalarray;

public class Declaration {
    static void main(String[] args) {
        int[][] arr = {{2, 3, 4}, {6, 5, 4}}; // 2*3 regular array
        int[][] brr = new int[][]{{3, 4, 3}, {5, 6, 3}}; // ✅ 2*3 regular array
//        for(int i=0; i<arr.length; i++){
//            for(int j=0; j<arr[0].length; j++){
//                System.out.print(arr[i][j]+" ");
//            }
        //       System.out.println();
//        }
        for(int[] a : arr){
            for(int ele : a){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
}
