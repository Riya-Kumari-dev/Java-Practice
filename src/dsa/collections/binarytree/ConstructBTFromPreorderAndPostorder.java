package dsa.collections.binarytree;

import java.util.Arrays;
import java.util.Scanner;

import static dsa.collections.binarytree.Implementation.display;

public class ConstructBTFromPreorderAndPostorder {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the binary tree : ");
        int n = sc.nextInt();
        int[] post = new int[n];
        System.out.print("Enter postorder traversal of the binary tree : ");
        for(int i=0; i<n; i++){
            post[i] = sc.nextInt();
        }
        int[] pre = new int[n];
        System.out.print("Enter preorder traversal of the binary tree : ");
        for(int i=0; i<n; i++){
            pre[i] = sc.nextInt();
        }

        Node root = buildTree(pre, post);
        System.out.println("Postorder : "+ Arrays.toString(post));
        System.out.println("Preorder : "+Arrays.toString(pre));
        display(root);
    }

    // there can be multiple trees with preorder and postorder traversal given
    private static Node buildTree(int[] preorder, int[] postorder) {
        return helper(preorder,0, preorder.length-1, postorder, 0, postorder.length-1);
    }
    private static Node helper(int[] preorder, int prelo, int prehi, int[] postorder, int postlo, int posthi){
        if(prelo > prehi || postlo > posthi) return null;

        // last node of postorder will be root node
        int data = postorder[posthi];
        Node root = new Node(data);

        if(prelo == prehi) return root;

        int lr = postlo; // will point to root of left subtree
        while(postorder[lr] != preorder[prelo+1]) lr++; // prelo+1 would be the root of the left subtree
        int leftSize = lr - postlo + 1; // left tree ka size

        root.left = helper(preorder, prelo+1, prelo+leftSize, postorder, postlo, lr);
        root.right = helper(preorder, prelo + leftSize +1, prehi, postorder, lr+1, posthi-1);

        return root;
    }
}