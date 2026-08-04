package dsa.dynamicprogramming;

import dsa.datastructures.binarytree.Node;

import java.util.Scanner;

import static dsa.datastructures.binarytree.ConstructBTUsingBFS.construct;
import static dsa.datastructures.binarytree.ConstructBTUsingBFS.print;

public class BalancedBinaryTree {
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
        if(isBalanced(root)) System.out.println("Yes, the given tree is balanced.");
        else System.out.println("No, the given tree is not balanced.");

    }
    private static int level(Node root, boolean[] flag){
        if(root == null) return 0;
        int leftLevel = level(root.left,flag);
        int rightLevel = level(root.right, flag);
        if(Math.abs(level(root.left, flag) - level(root.right, flag)) >1) flag[0] =  false;
        return 1 + Math.max(leftLevel, rightLevel);
    }
    private static boolean isBalanced(Node root) {
        boolean[] flag = {true};
        level(root, flag);
        return flag[0];
    }

    // memoization using hashmap
//    private static int level(Node root, HashMap<Node, Integer> dp){
//        if(root == null) return 0;
//        if(dp.containsKey(root)) return dp.get(root);
//        int leftLevel = level(root.left, dp);
//        int rightLevel = level(root.right, dp);
//        dp.put(root, 1 + Math.max(leftLevel, rightLevel));
//        return dp.get(root);
//    }
//    private static boolean isBalanced(Node root) {
//        if(root == null) return true;
//        HashMap<Node, Integer> dp = new HashMap<>();
//        if(Math.abs(level(root.left, dp) - level(root.right, dp)) >1) return false;
//        return isBalanced(root.left) && isBalanced(root.right);
//    }
    // recursion
//    private static int level(Node root){
//        if(root == null) return 0;
//        int leftLevel = level(root.left);
//        int rightLevel = level(root.right);
//        return 1 + Math.max(leftLevel, rightLevel);
//    }
//    private static boolean isBalanced(Node root) {
//        if(root == null) return true;
//        if(Math.abs(level(root.left) - level(root.right)) >1) return false;
//        return isBalanced(root.left) && isBalanced(root.right);
//    }
}
