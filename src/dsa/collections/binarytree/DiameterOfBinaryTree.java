package dsa.collections.binarytree;

import static dsa.collections.binarytree.Implementation.display;
import static dsa.collections.binarytree.Level.level;

public class DiameterOfBinaryTree {
    static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(-1);
        Node e = new Node(1);
        Node f = new Node(6);
        Node g = new Node(9);
        Node h = new Node(10);
        Node i = new Node(11);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = h;
        e.right = i;

        display(a);
        System.out.println();
        System.out.println("Diameter of Given Binary Tree : "+diameterOfBinaryTree(a));

    }
    // TC = O(n^2)
    private static int diameterOfBinaryTree(Node root) {
        if(root == null) return 0;
        int myDia = level(root.left) + level(root.right);
        int leftDia = diameterOfBinaryTree(root.left);
        int rightDia = diameterOfBinaryTree(root.right);
        return Math.max(myDia, Math.max(leftDia, rightDia));
    }
}