package dsa.collections.binarysearchtree;
import dsa.collections.binarytree.Node;

import java.util.Scanner;

import static dsa.collections.binarytree.ConstructBTUsingBFS.construct;
import static dsa.collections.binarytree.ConstructBTUsingBFS.print;

public class Insertion {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the levels of the tree : ");
        int l = sc.nextInt();
        int n = (int)Math.pow(2, l) -1;
        int[] arr = new int[n];
        System.out.print("Enter "+n+" elements for the tree (for null please enter '-2147483648') : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Node root = construct(arr, n);

        print(root);
        System.out.print("Enter the element to be inserted : ");
        int ele = sc.nextInt();
        root = insertIntoBST(root, ele);
        print(root);
    }

    // TC = O(h) = SC
    // using Node as a return type
    private static Node insertIntoBST(Node root, int ele) {
        if(root == null) return new Node(ele);
        if(root.val<ele) { // attach to right
            root.right =  insertIntoBST(root.right, ele);
        }
        else{ // attach to left
            root.left =  insertIntoBST(root.left, ele);
        }
        return root;
    }

    // using void return type
    // TC = O(h) = SC
//    private static Node insertIntoBST(Node root, int ele) {
//        if(root == null) return new Node(ele);
//        insert(root, ele);
//        return root;
//    }
//
//    private static void insert(Node root, int ele) {
//        if(root.val<ele){ // attach to right
//            if(root.right == null) root.right = new Node(ele);
//            else insert(root.right, ele);
//        }
//        else{ // attach to left
//            if(root.left == null) root.left = new Node(ele);
//            else insert(root.left, ele);
//        }
//    }
}