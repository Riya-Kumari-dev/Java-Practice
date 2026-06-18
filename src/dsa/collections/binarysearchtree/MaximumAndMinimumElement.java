package dsa.collections.binarysearchtree;

import dsa.collections.binarytree.Node;

import java.util.Scanner;

import static dsa.collections.binarytree.ConstructBTUsingBFS.construct;
import static dsa.collections.binarytree.ConstructBTUsingBFS.print;

public class MaximumAndMinimumElement {
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
        System.out.println("Maximum Element of the given binary search tree is "+maximumElement(root));
        System.out.println("Minimum Element of the given binary search tree is "+minimumElement(root));
    }

    private static int minimumElement(Node root) {
        if(root == null) return Integer.MAX_VALUE;
        while(root.left != null) root = root.left;
        return root.val;
    }

    private static int maximumElement(Node root) {
        if(root == null) return Integer.MIN_VALUE;
        while(root.right != null){
            root = root.right;
        }
        return root.val;
    }
}