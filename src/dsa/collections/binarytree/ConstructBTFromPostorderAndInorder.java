package dsa.collections.binarytree;

import java.util.Arrays;
import java.util.Scanner;

import static dsa.collections.binarytree.Implementation.display;

public class ConstructBTFromPostorderAndInorder {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the binary tree : ");
        int n = sc.nextInt();
        int[] post = new int[n];
        System.out.print("Enter postorder traversal of the binary tree : ");
        for(int i=0; i<n; i++){
            post[i] = sc.nextInt();
        }
        int[] in = new int[n];
        System.out.print("Enter inorder traversal of the binary tree : ");
        for(int i=0; i<n; i++){
            in[i] = sc.nextInt();
        }

        Node root = buildTree(in, post);
        System.out.println("Postorder : "+ Arrays.toString(post));
        System.out.println("Inorder : "+Arrays.toString(in));
        display(root);
    }

    private static Node buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    private static Node helper(int[] inorder, int inlo, int inhi, int[] postorder, int postlo, int posthi){
        if(postlo > posthi) return null;

        // last node of postorder will be root node
        int data = postorder[posthi];
        Node root = new Node(data);

        int r = inlo;
        while(inorder[r] != postorder[posthi]) r++;
        int leftSize = r - inlo; // left tree ka size

        root.left = helper(inorder, inlo, r-1, postorder, postlo, postlo +leftSize-1);
        root.right = helper(inorder, r+1, inhi, postorder, postlo +leftSize, posthi-1);

        return root;
    }
}