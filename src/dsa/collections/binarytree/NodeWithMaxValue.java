package dsa.collections.binarytree;

import static dsa.collections.binarytree.Implementation.display;

public class NodeWithMaxValue {
    static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(-1);
        Node e = new Node(1);
        Node f = new Node(6);
        Node g = new Node(9);

        a.left = b; a.right = c;
        b.left = d; b.right = e;  c.left = f; c.right = g;

        display(a);
        System.out.println();
        System.out.println("Node with maximum value : "+maxValue(a));
    }

    private static int maxValue(Node root) {
        if(root == null) return Integer.MIN_VALUE;
        return Math.max(root.val , Math.max(maxValue(root.left), maxValue(root.right)));
    }
}