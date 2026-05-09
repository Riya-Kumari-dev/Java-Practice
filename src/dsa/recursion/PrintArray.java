package dsa.recursion;

public class PrintArray {
    static void main(String[] args) {
        int[] arr = {3,2,6,9,1};
        print(arr,0);
        System.out.println();
        reverse(arr, 0);
    }
    static void print(int[] arr, int idx){
        if(idx == arr.length) return;
        System.out.print(arr[idx]+" ");
        print(arr, idx+1);
    }
    static void reverse(int[] arr, int idx){
        if(idx == arr.length) return;
        reverse(arr, idx+1);
        System.out.print(arr[idx]+" ");
    }
}
