package dsa.collections.binarysearchtree;

import dsa.collections.binarytree.Node;

import java.util.Scanner;

import static dsa.collections.binarytree.ConstructBTUsingBFS.construct;
import static dsa.collections.binarytree.ConstructBTUsingBFS.print;

public class Search {
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
        System.out.print("Enter the target to be searched : ");
        int target = sc.nextInt();
        print(root);

        Node targetRoot = searchBST(root, target);
        print(targetRoot);
    }

    // Best case (Balanced binary tree) TC = O(log(n)) = SC
    // Avg and worst case => TC = O(h) = SC ,  where h is height/levels of the tree
    private static Node searchBST(Node root, int target) {
        if(root == null) return null;
        if(root.val == target) return root;
        if(root.val < target) return searchBST(root.right, target); // target greater than root.val mean target can be in the right subtree so search there
        return searchBST(root.left, target); // else can be in the left subtree
    }
}