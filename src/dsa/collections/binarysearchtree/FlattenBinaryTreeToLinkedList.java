package dsa.collections.binarysearchtree;

import dsa.collections.binarytree.Node;

import java.util.ArrayList;
import java.util.Scanner;

import static dsa.collections.binarytree.ConstructBTUsingBFS.construct;
import static dsa.collections.binarytree.ConstructBTUsingBFS.print;

public class FlattenBinaryTreeToLinkedList {
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
        flatten(root);
        print(root);
    }

    // Using similar approach as Morris Traversal
    // => we can also find the preorder using SC = O(1) using this approach as in this approach we are creating a linked list of preorder traversal
    // TC = O(n) , SC = O(1)
    private static void flatten(Node root) {
        Node curr = root;
        while(curr != null){
            if(curr.left != null){
                Node rst = curr.right; // mark the right subtree
                // change curr.right
                curr.right = curr.left;
                // find predecessor
                Node pred = curr.left;
                while(pred.right != null) pred = pred.right;
                // pred hi last node hoga of lst
                pred.right = rst;
                curr.left = null;
                curr = curr.right;
            }
            else curr = curr.right;
        }
    }

    // Recursion based
    // TC = O(n) = SC => recursive space
//    private static void flatten(Node root) {
//        if(root == null) return;
//        Node lst = root.left;
//        Node rst = root.right;
//        flatten(lst);
//        flatten(rst);
//        root.left = null;
//        root.right = lst;
//        Node temp = root;
//        while(temp.right != null) temp = temp.right;
//        temp.right = rst;
//    }

    // TC = O(n) = SC
//    private static void flatten(Node root) {
//        ArrayList<Node> pre = new ArrayList<>();
//        preorder(root, pre);
//        for(int i=0; i<pre.size(); i++){
//            if(i!= pre.size()-1) pre.get(i).right = pre.get(i+1);
//            pre.get(i).left = null;
//        }
//
//    }
//
//    private static void preorder(Node root, ArrayList<Node> pre) {
//        if(root == null) return;
//        pre.add(root);
//        preorder(root.left, pre);
//        preorder(root.right, pre);
//    }
}