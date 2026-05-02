package exceptionhandling.trycatch;

import java.util.Scanner;

public class MultipleTryCatch {
    static void main(String[] args) {
        System.out.println("Connection Established");
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4];
        try {
            System.out.print("Enter the size of the array : ");
            int n = sc.nextInt();
            arr = new int[n];
        }
        catch(NegativeArraySizeException e){
            System.out.println("Please don't be negative!");
        }
        try{
            System.out.print("Kindly enter the element to be inserted : ");
            int ele = sc.nextInt();
            System.out.print("Enter the index where the element to be inserted : ");
            int idx = sc.nextInt();
            arr[idx] = ele;
            System.out.println();
            System.out.println(arr[idx]);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Please be in your limits");
        }
        catch(Exception e){
            System.out.println("Some problem, please check out your code");
        }
        System.out.println("Connection Terminated");
    }
}
