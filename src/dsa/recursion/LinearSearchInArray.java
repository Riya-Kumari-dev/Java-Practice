package dsa.recursion;

public class LinearSearchInArray {
    static void main(String[] args) {
        int[] arr = {3,2,6,9,1};
        print(arr,0);
        System.out.println();
        System.out.println(exists(arr,6,0));
    }
    static void print(int[] arr, int idx){
        if(idx == arr.length) return;
        System.out.print(arr[idx]+" ");
        print(arr, idx+1);
    }
    static boolean exists(int[] arr, int ele, int idx){
        if(arr[idx] == arr.length) return false;
        if(arr[idx] == ele) return true;
        return exists(arr, ele, idx+1);
    }
}
