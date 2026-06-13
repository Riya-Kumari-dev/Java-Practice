package dsa.collections.binarytree;

import java.util.Scanner;
import java.util.Arrays;
import static dsa.collections.binarytree.Implementation.display;

public class ConstructBTFromPreOrderAndInorder {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the binary tree : ");
        int n = sc.nextInt();
        int[] pre = new int[n];
        System.out.print("Enter preorder traversal of the binary tree : ");
        for(int i=0; i<n; i++){
            pre[i] = sc.nextInt();
        }
        int[] in = new int[n];
        System.out.print("Enter inorder traversal of the binary tree : ");
        for(int i=0; i<n; i++){
            in[i] = sc.nextInt();
        }

        Node root = buildTree(in, pre);
        System.out.println("Preorder : "+Arrays.toString(pre));
        System.out.println("Inorder : "+Arrays.toString(in));
        display(root);
    }

    private static Node buildTree(int[] inorder, int[] preorder) {
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