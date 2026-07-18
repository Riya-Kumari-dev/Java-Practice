package dsa.binarysearch;

import java.util.Scanner;

public class AllocateMinimumPages {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of the books : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter total number of pages in each book : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the number of students : ");
        int k = sc.nextInt();
        System.out.println("Minimum maximum allocation is : "+findPages(arr, k));

    }
    // . The task is to allocate books to each student such that
    //Each student receives at least one book.
    //Each student is assigned a contiguous sequence of books.
    //No book is assigned to more than one student.
    //All books must be allocated.
    // The objective is to minimize the maximum number of pages assigned to any student
    private static int findPages(int[] arr, int k) {
        // code here
        int sum = 0;
        if(k>arr.length) return -1;
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            sum += j;
            max = Math.max(max, j);
        }
        int lo = max;
        int hi = sum;
        int ans = -1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(students(arr,mid) <= k){
                ans = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return ans;
    }
    private static int students(int[] arr, int pages){
        int student = 0;
        int p = pages;
        for (int ele : arr) {
            if (p < ele) {
                student++;
                p = pages;
            }
            p -= ele;
        }
        student++;
        return student;
    }
}