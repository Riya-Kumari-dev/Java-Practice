package dsa.sorting;

public class CyclicSort {
    static void main(String[] args) {
        // elements from 1 to n
        int[] arr = {4,3,8,2,1,7,6,5};
        cycleSort(arr);
        for(int ele : arr){
            System.out.print(ele+" ");
        }

    }
    private static void cycleSort(int[] arr){
//        for(int i=0; i<arr.length; i++){
//            arr[i] = i+1;
//        }
        int i=0;
        while(i<arr.length){
            if(arr[i] == i+1) i++;
            else{
                int idx = arr[i]-1;
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
            }
        }
    }
}
