package dsa.collections.binarysearchtree;

import dsa.collections.binarytree.Node;

import java.util.ArrayList;
import java.util.Scanner;

import static dsa.collections.binarytree.ConstructBTUsingBFS.construct;
import static dsa.collections.binarytree.ConstructBTUsingBFS.print;

public class ValidateBST {
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

        if(isValidBST(root)) System.out.println("Yes, the given tree is a valid BST");
        else System.out.println("No, the given tree is not a valid BST");
    }
    // max(Left Subtree) < root.val < min(right Subtree)

    // Method 3 : Using Inorder Traversal but no extra space
    // TC = O(n)
    static boolean flag;
    static Node prev = null;
    private static boolean isValidBST(Node root) {
        flag = true;
        int prev = Integer.MIN_VALUE;
        inorder(root);
        return flag;
    }

    private static void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        if(prev != null && prev.val >= root.val) flag = false;
        prev = root;
        inorder(root.right);
    }


    // Method 2 : Using inorder traversal but storing in arraylist
    // TC = O(n) , SC = O(n)
//    private static boolean isValidBST(Node root) {
//        ArrayList<Integer> ans = new ArrayList<>();
//        inorder(root, ans);
//        for(int i=1; i<ans.size(); i++){
//            if(ans.get(i) < ans.get(i-1)) return false;
//        }
//        return true;
//    }
//
//    private static void inorder(Node root, ArrayList<Integer> ans) {
//        if(root == null) return;
//        inorder(root.left, ans);
//        ans.add(root.val);
//        inorder(root.right, ans);
//    }


    // Method 1 => using max, min
    // Best case TC = O(nlog(n))
    // worst case TC = O(n^2)
//    private static boolean isValidBST(Node root) {
//        if(root == null) return true;
//        if(root.val <= max(root.left)) return false;
//        if(root.val >= min(root.right)) return false;
//        return isValidBST(root.left) && isValidBST(root.right);
//
//    }
//    private static long min(Node root) {
//        if(root == null) return Long.MAX_VALUE;
//        while(root.left != null) root = root.left;
//        return root.val;
//    }
//
//    private static long max(Node root) {
//        if(root == null) return Long.MIN_VALUE;
//        while(root.right != null){
//            root = root.right;
//        }
//        return root.val;
//    }
}