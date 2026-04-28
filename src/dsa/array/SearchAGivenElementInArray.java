package dsa.array;

import java.util.Scanner;

public class SearchAGivenElementInArray {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter "+n+" elements for the array : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the number : ");
        int x = sc.nextInt(); // the target element
        boolean flag = false;
        for(int ele : arr){
            if(x == ele){
                flag = true;
                break;
            }
        }
        if(flag) System.out.println(x+" is present in the given array");
        else System.out.println(x+" is not present in the given array.");
    }
}
