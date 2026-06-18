package dsa.collections.binarysearchtree;

import dsa.collections.binarytree.Node;

import java.util.Scanner;

import static dsa.collections.binarytree.ConstructBTUsingBFS.construct;
import static dsa.collections.binarytree.ConstructBTUsingBFS.print;

public class BSTtoGreaterSumTree {
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

        Node newRoot = bstToGst(root);
        print(newRoot);
    }

    //  convert it to a Greater Tree such that
    //  every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.


    // TC = O(n), SC = O(h)
    static int sum;
    private static Node bstToGst(Node root) {
        sum = 0;
        reverseInorder(root);
        return root;
    }

    private static void reverseInorder(Node root) {
        if(root == null) return;
        reverseInorder(root.right);
        root.val += sum;
        sum = root.val;
        reverseInorder(root.left);
    }

    // TC = O(n) = SC
    // extra space used
//    private static Node bstToGst(Node root) {
//        ArrayList<Node> arr = new ArrayList<>();
//        inorder(root, arr);
//        int n = arr.size();
//        for(int i=n-2; i>=0; i--){
//            arr.get(i).val += arr.get(i+1).val;
//        }
//        return root;
//    }
//
//    private static void inorder(Node root, ArrayList<Node> arr) {
//        if(root == null) return;
//        inorder(root.left, arr);
//        arr.add(root);
//        inorder(root.right, arr);
//    }
}