package dsa.collections.binarysearchtree;

import dsa.collections.binarytree.Node;

import java.util.Scanner;

import static dsa.collections.binarytree.ConstructBTUsingBFS.construct;
import static dsa.collections.binarytree.ConstructBTUsingBFS.print;

public class RangeSumOfBST {
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

        System.out.print("Enter values range : ");
        int low = sc.nextInt();
        int hi = sc.nextInt();

        print(root);
        System.out.println("Sum of all nodes val between "+low+" and "+hi+" is "+rangeSumBST(root, low, hi));
    }

    // Given the root node of a binary search tree and two integers low and high,
    // return the sum of values of all nodes with a value in the inclusive range [low, high].
    private static int  rangeSumBST(Node root, int low, int hi) {
        if(root == null) return 0;
        if(root.val < low) return rangeSumBST(root.right, low, hi);
        else if(root.val > hi) return rangeSumBST(root.left, low, hi);
        return root.val + rangeSumBST(root.right, low, hi) + rangeSumBST(root.left, low, hi);
    }
}