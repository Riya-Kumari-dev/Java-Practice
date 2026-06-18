package dsa.collections.binarysearchtree;

import dsa.collections.binarytree.Node;

import java.util.Arrays;
import java.util.Scanner;

import static dsa.collections.binarytree.ConstructBTUsingBFS.print;

public class ConstructBSTFromPreOrderTraversal {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the binary tree : ");
        int n = sc.nextInt();
        int[] pre = new int[n];
        System.out.print("Enter preorder traversal of the binary tree : ");
        for (int i = 0; i < n; i++) {
            pre[i] = sc.nextInt();
        }
        Node root = bstFromPreOrder(pre);
        print(root);
    }

    private static Node bstFromPreOrder(int[] preorder) {
        int n = preorder.length;
        int[] inorder = Arrays.copyOf(preorder, n);
        Arrays.sort(inorder);
        return helper(inorder,0, inorder.length-1, preorder, 0, preorder.length-1);
    }
    private static Node helper(int[] inorder, int inlo, int inhi, int[] preorder, int prelo, int prehi){
        if(prelo > prehi) return null;

        // first node of preorder will be root node
        int data = preorder[prelo];
        Node root = new Node(data);

        int r = inlo;
        while(inorder[r] != preorder[prelo]) r++;
        int leftSize = r - inlo; // left tree ka size

        root.left = helper(inorder, inlo, r-1, preorder, prelo+1, prelo+leftSize);
        root.right = helper(inorder, r+1, inhi, preorder, prelo+leftSize+1, prehi);

        return root;
    }
}