package dsa.dynamicprogramming;

import dsa.datastructures.binarytree.Node;

import java.util.Scanner;

import static dsa.datastructures.binarytree.ConstructBTUsingBFS.construct;
import static dsa.datastructures.binarytree.ConstructBTUsingBFS.print;

public class BinaryTreeMaximumPathSum {
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
        System.out.println("The maximum path sum in the given tree is "+maxPathSum(root));

    }
    private static int rootToLeafSum(Node root, int[] maxPath){
        if(root == null) return 0;
        int left = rootToLeafSum(root.left, maxPath);
        int right = rootToLeafSum(root.right, maxPath);
        int pathSum = root.val;
        if(left >=0) pathSum += left;
        if(right >= 0) pathSum += right;
        maxPath[0] = Math.max(maxPath[0], pathSum);
        return root.val + Math.max(0, Math.max(left, right));
    }
    private static int maxPathSum(Node root) {
        int[] maxPath = {Integer.MIN_VALUE};
        rootToLeafSum(root, maxPath);
        return maxPath[0];
    }
}