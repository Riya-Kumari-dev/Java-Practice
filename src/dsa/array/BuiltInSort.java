package dsa.array;

import java.util.Arrays;

public class BuiltInSort {
    static void main(String[] args) {
        int[] arr = {2,1,5,3,7};
        print(arr);
        Arrays.sort(arr);
        print(arr);
    }
    static void print(int[] arr){
        for(int ele : arr){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
}
