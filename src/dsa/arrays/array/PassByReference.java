package dsa.arrays.array;

public class PassByReference {
    static void main(String[] args) {
        int[] arr = {4, 3, 1, 0, 5};
        for(int ele : arr){
            System.out.print(ele+" ");
        }
        change(arr);
        System.out.println();
        for(int ele : arr){
            System.out.print(ele+" ");
        }
    }
    static void change(int[] x){ // array are passed by reference
        x[2] = 7;
    }
}
