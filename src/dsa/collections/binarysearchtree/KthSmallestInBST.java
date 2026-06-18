package dsa.collections.binarysearchtree;

import dsa.collections.binarytree.Node;

import java.util.ArrayList;
import java.util.Scanner;

import static dsa.collections.binarytree.ConstructBTUsingBFS.construct;
import static dsa.collections.binarytree.ConstructBTUsingBFS.print;

public class KthSmallestInBST {
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
        System.out.print("Enter k : ");
        int k = sc.nextInt();
        System.out.println(k+"th smallest element in the given BST is "+kthSmallest(root, k));
    }

    static int k2;
    static int ans;
    private static int kthSmallest(Node root, int k) {
        k2 = k;
        ans = -1;
        inorder(root);
        return ans;
    }

    private static void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        k2--;
        if(k2 == 0) ans = root.val;
        inorder(root.right);

    }
//    private static int kthSmallest(Node root, int k) {
//        ArrayList<Integer> in = new ArrayList<>();
//        inorder(root, in);
//        return in.get(k-1);
//    }
//
//    private static void inorder(Node root, ArrayList<Integer> in) {
//        if(root == null) return;
//        inorder(root.left, in);
//        in.add(root.val);
//        inorder(root.right, in);
//    }
}