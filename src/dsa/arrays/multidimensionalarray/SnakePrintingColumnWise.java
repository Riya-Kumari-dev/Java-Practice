package dsa.arrays.multidimensionalarray;

public class SnakePrintingColumnWise {
    static void main(String[] args) {
        int[][] arr = {{2,8,3,4,7},{7,2,1,6,3},{5,5,4,1,4},{3,1,8,2,6}};
        print(arr);
        System.out.println("The Snake Printing Column wise : ");
        for(int i=0; i<arr[0].length; i++){
            if(i%2==0){
                for(int j=0; j<arr.length; j++){
                    System.out.print(arr[j][i]+" ");
                }
            }
            else{
                for(int j=arr.length-1; j>=0; j--){
                    System.out.print(arr[j][i]+" ");
                }
            }
            System.out.println();
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
