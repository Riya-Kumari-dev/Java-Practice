package dsa.collections.binarysearchtree;

import dsa.collections.binarytree.Node;

import java.util.Scanner;

import static dsa.collections.binarytree.ConstructBTUsingBFS.construct;
import static dsa.collections.binarytree.ConstructBTUsingBFS.print;

public class DeleteNodeInABST {
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

        System.out.print("Enter the node value to be deleted : ");
        int key = sc.nextInt();
        root = deleteNode(root, key);
        print(root);
    }

    private static Node deleteNode(Node root, int key) {
        if(root == null) return null;
        if(root.val == key){
            // case 1 : 0 child => leaf node
            if(root.left == null && root.right == null) return null;

            // case 2 : 1 child
            else if(root.left == null || root.right == null){
                if(root.left == null) return root.right;
                else return root.left;
            }

            // case 3 : 2 children
            else{
                // find the predecessor
                Node pred = root.left;
                while(pred.right != null) pred = pred.right;

                root.val = pred.val;// copy the pred value to root value
                root.left = deleteNode(root.left, pred.val); // delete predecessor
            }
        }
        else if(root.val > key){ // LST will change
            root.left = deleteNode(root.left, key);

        }
        else { // RST will change
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}