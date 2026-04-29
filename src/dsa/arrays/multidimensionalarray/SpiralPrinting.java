package dsa.arrays.multidimensionalarray;

public class SpiralPrinting {
    static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, {19, 20, 21, 22, 23, 24}, {25, 26, 27, 28, 29, 30}};
        print(arr);
        System.out.println("Spiral Printing : ");
        int minrow = 0;
        int maxrow = arr.length-1;
        int mincol = 0;
        int maxcol = arr[0].length-1;
        // total element is m*n
        int total = arr.length*arr[0].length;
        int count = 0;
        while(count<=total){
            if(count>=total) break;
            for(int j= mincol; j<=maxcol; j++){
                System.out.print(arr[minrow][j]+" ");
                count++;
            }
            System.out.println();
            minrow++;
            if(count>=total) break;
            for(int i=minrow; i<=maxrow; i++){
                System.out.print(arr[i][maxcol]+" ");
                count++;
            }
            System.out.println();
            maxcol--;
            if(count>=total) break;
            for(int j=maxcol; j>=mincol; j--){
                System.out.print(arr[maxrow][j]+" ");
                count++;
            }
            maxrow--;
            System.out.println();
            if(count>=total) break;
            for(int i=maxrow;i>=minrow; i--){
                System.out.print(arr[i][mincol]+" ");
                count++;
            }
            mincol++;
            System.out.println();
            //if(count>total) break;
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
