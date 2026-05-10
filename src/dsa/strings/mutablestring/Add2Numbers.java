package dsa.strings.mutablestring;

import java.util.Scanner;

public class Add2Numbers {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the first array : ");
        int m = sc.nextInt();
        int[] arr1 = new int[m];
        System.out.print("Enter " + m + " elements for the array : ");
        for (int i = 0; i < m; i++) {
            arr1[i] = sc.nextInt();
        }
        System.out.print("Enter the size of the second array : ");
        int n = sc.nextInt();
        int[] arr2 = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        System.out.println();
        for(int ele : arr1){
            System.out.print(ele+" ");
        }
        System.out.println();
        for(int ele : arr2){
            System.out.print(ele+" ");
        }
        System.out.println();
        System.out.print("Adding both we get : "+addNumbers(arr1, arr2));
    }

    private static String addNumbers(int[] arr1, int[] arr2) {
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        int m = arr1.length;
        int n = arr2.length;
        int i=m-1;
        int j=n-1;
        while(i >= 0 || j >= 0 || carry > 0) { // carry > 0 agar last me carry bach gya uske liye
            int sum = carry;
            if(i >= 0) {
                sum += arr1[i];
                i--;
            }
            if(j >= 0) {
                sum += arr2[j];
                j--;
            }
            ans.append(sum % 10);
            carry = sum / 10;
        }
        ans.reverse();
        return ans.toString();
    }
}
