package exceptionhandling.trycatch;

import java.util.Scanner;

public class TryWithMultipleCatch {
    static void main(String[] args) {
        System.out.println("Connection Established : ");
        Scanner sc = new Scanner(System.in);
        // try without catch ❌
        // catch without try ❌
        // try with multiple catch ✅
        // but catch exceptions should be like child exceptions first then parent as it will not propagate down after seeing parent one . thus leading to compile time error
        try{
            System.out.print("Enter the size of the array : ");
            int n  = sc.nextInt();
            int[] arr = new int[n];
            System.out.print("Kindly enter the element to be inserted : ");
            int ele = sc.nextInt();
            System.out.print("Enter the index where the element to be inserted : ");
            int idx = sc.nextInt();
            arr[idx] = ele;
            System.out.println();
            System.out.println(arr[idx]);
        }
        // there can be multiple exceptions right now array index out of bound negative array size etc.
        catch(NegativeArraySizeException e){
            System.out.println("Please don't be negative!");
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Please be in your limits");
        }
        // there can be other problems also so recommended to use Exception  at the last to handle all type of exception
        catch(Exception e){
            System.out.println("Some problem, please check out your code");
        }
        System.out.println("Connection Terminated");
    }
}
