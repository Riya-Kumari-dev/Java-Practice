package dsa.collections.binarytree;

import static dsa.collections.binarytree.Implementation.display;

public class ProductOfNonZeroElementsOfNodes {
    static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(0);
        Node c = new Node(2);
        Node d = new Node(-1);
        Node e = new Node(0);
        Node f = new Node(6);
        Node g = new Node(9);

        a.left = b; a.right = c;
        b.left = d; b.right = e;  c.left = f; c.right = g;

        display(a);
        System.out.println();
        System.out.println("Product of all the non zero elements of nodes : "+ productOfNonZero(a));
    }

    private static int productOfNonZero(Node root) {
        if(root == null) return 1;
        if(root.val != 0) return root.val * productOfNonZero(root.left) * productOfNonZero(root.right);
        else return productOfNonZero(root.left) * productOfNonZero(root.right);
    }
}