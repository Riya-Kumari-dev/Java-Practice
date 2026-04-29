package dsa.arrays.array;

public class MultiplyOddIndexedBy2AndAdd10ToEvenIndexed {
    static void main(String[] args){
        int[] arr = {2,1,5,3,7};
        print(arr);
        for(int i=0; i<arr.length; i++){
            if(i%2 == 0) arr[i] += 10;
            else arr[i] *= 2;
        }
        print(arr);
    }
    static void print(int[] arr){
        // for each loop
        for(int ele : arr){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
}
