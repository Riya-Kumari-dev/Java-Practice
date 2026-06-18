package dsa.collections.binarysearchtree;

import dsa.collections.binarytree.Node;

import java.util.ArrayList;
import java.util.Scanner;

import static dsa.collections.binarytree.ConstructBTUsingBFS.construct;
import static dsa.collections.binarytree.ConstructBTUsingBFS.print;

public class BalanceABST {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the levels of the tree : ");
        int l = sc.nextInt();
        int n = (int) Math.pow(2, l) - 1;
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the tree (for null please enter '-2147483648') : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Node root = construct(arr, n);

        print(root);
        root = balanceBST(root);
        print(root);
    }

    private static Node balanceBST(Node root) {
        ArrayList<Node> arr = new ArrayList<>();
        inorder(root,arr);
        return helper(arr, 0, arr.size()-1);
    }

    private static Node helper(ArrayList<Node> arr, int lo, int hi) {
        if(lo>hi) return null;
        int mid = lo + (hi-lo)/2;
        Node root = arr.get(mid);
        root.left = helper(arr, lo, mid-1);
        root.right = helper(arr, mid+1, hi);
        return root;
    }

    private static void inorder(Node root, ArrayList<Node> arr) {
        if(root == null) return;
        inorder(root.left, arr);
        arr.add(root);
        inorder(root.right, arr);
    }

    // Creating a new BST
//    private static Node balanceBST(Node root) {
//        ArrayList<Integer> arr = new ArrayList<>();
//        inorder(root,arr);
//        return helper(arr, 0, arr.size()-1);
//    }
//
//    private static Node helper(ArrayList<Integer> arr, int lo, int hi) {
//        if(lo>hi) return null;
//        int mid = lo + (hi-lo)/2;
//        Node root = new Node(arr.get(mid));
//        root.left = helper(arr, lo, mid-1);
//        root.right = helper(arr, mid+1, hi);
//        return root;
//    }
//
//    private static void inorder(Node root, ArrayList<Integer> arr) {
//        if(root == null) return;
//        inorder(root.left, arr);
//        arr.add(root.val);
//        inorder(root.right, arr);
//    }
}