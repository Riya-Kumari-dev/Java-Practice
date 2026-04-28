package dsa.array;

import java.util.Arrays;

public class ShallowAndDeepCopy {
    static void main(String[] args) {
        int[] arr = {2,1,5,3,7};
        print(arr);
        int[] x = arr; // shallow copy ( the changes will reflect in the original array
        x[2] = 4;
        print(arr);
        int[] y = Arrays.copyOf(arr, arr.length); // deep copy
        y[2] = 10;
        print(arr);
        print(y);
    }
    static void print(int[] arr){
        for(int ele : arr){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
}
