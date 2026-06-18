package dsa.collections.binarysearchtree;

import dsa.collections.binarytree.Node;

import java.util.Arrays;
import java.util.Scanner;

import static dsa.collections.binarytree.ConstructBTUsingBFS.print;

public class ConvertSortedArrayToBalancedBST {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the given array (sorted) : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        Node root = sortedArrayToBST(arr);
        print(root);
    }

    private static Node sortedArrayToBST(int[] arr) {
        int n = arr.length;
        return helper(arr, 0, n-1);
    }

    private static Node helper(int[] arr, int lo, int hi) {
        if(lo>hi) return null;
        int mid = lo + (hi-lo)/2;
        Node root = new Node(arr[mid]);
        root.left = helper(arr, lo, mid-1);
        root.right = helper(arr, mid+1, hi);
        return root;
    }
}