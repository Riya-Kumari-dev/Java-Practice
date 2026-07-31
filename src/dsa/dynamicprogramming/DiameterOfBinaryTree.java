package dsa.dynamicprogramming;

import dsa.collections.binarytree.Node;

import java.util.Scanner;

import static dsa.collections.binarytree.ConstructBTUsingBFS.construct;
import static dsa.collections.binarytree.ConstructBTUsingBFS.print;

public class DiameterOfBinaryTree {
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
        System.out.println("Diameter of the given tree is "+diameterOfBinaryTree(root));
    }
    // TC = O(n), AS = O(h)
    private static int level(Node root, int[] maxDia){
        if(root == null) return 0;
        int leftLevel = level(root.left, maxDia);
        int rightLevel = level(root.right, maxDia);
        int myDia = leftLevel + rightLevel;
        maxDia[0] = Math.max(myDia, maxDia[0]);
        return 1 + Math.max(leftLevel, rightLevel);
    }
    private static int diameterOfBinaryTree(Node root) {
        int[] maxDia = {0};
        level(root, maxDia);
        return maxDia[0];
    }

    // memoization using hashmap
    // TC = O(n), AS = O(n)
//    private static int level(Node root, HashMap<Node, Integer> dp){
//        if(root == null) return 0;
//        if(dp.containsKey(root)) return dp.get(root);
//        int leftLevel = level(root.left, dp);
//        int rightLevel = level(root.right, dp);
//        dp.put(root, 1 + Math.max(leftLevel, rightLevel));
//        return dp.get(root);
//    }
//    private static int diameter(Node root, HashMap<Node, Integer> dp) {
//        if(root == null) return 0;
//        int myDia = level(root.left, dp) + level(root.right, dp);
//        int leftDia = diameter(root.left, dp);
//        int rightDia = diameter(root.right, dp);
//        return Math.max(myDia, Math.max(leftDia, rightDia));
//    }
//    private static int diameterOfBinaryTree(Node root) {
//        HashMap<Node, Integer> dp = new HashMap<>(); // node, level
//        return diameter(root, dp);
//    }

    // recursion
    // TC = O(n^2)
//    private static int level(Node root){
//            if(root == null) return 0;
//            int leftLevel = level(root.left);
//            int rightLevel = level(root.right);
//            return 1 + Math.max(leftLevel, rightLevel);
//
//    }
//    private static int diameter(Node root) {
//        if(root == null) return 0;
//        int myDia = level(root.left) + level(root.right);
//        int leftDia = diameter(root.left);
//        int rightDia = diameter(root.right);
//        return Math.max(myDia, Math.max(leftDia, rightDia));
//    }
}
