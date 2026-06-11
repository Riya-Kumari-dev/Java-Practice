package dsa.collections.binarytree;

import static dsa.collections.binarytree.Implementation.display;

public class InvertBinaryTree {
    static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        display(a);
        a = invert(a);
        System.out.println();
        display(a);
    }

    public static Node invert(Node root) {
        if(root == null) return null;
        if(root.left== null && root.right == null) return root;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        invert(root.left);
        invert(root.right);
        return root;
    }
}