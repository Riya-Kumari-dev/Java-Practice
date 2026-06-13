package dsa.collections.binarytree;

import static dsa.collections.binarytree.Implementation.display;

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

    // TC = O(n)
    private static int diameterOfBinaryTree(Node root) {
        int[] maxDia = {-1}; // to mark the diameter
        levels(root, maxDia);
        return maxDia[0];
    }

    private static int levels(Node root, int[] maxDia) {
        if(root == null){
            return 0;
        }
        int leftLevel = levels(root.left, maxDia);
        int rightLevel = levels(root.right, maxDia);

        // mark the diameter across the current root
        int dia = leftLevel + rightLevel;
        maxDia[0] = Math.max(dia, maxDia[0]);
        return 1 + Math.max(leftLevel, rightLevel);
    }

    // TC = O(n^2)
//    private static int diameterOfBinaryTree(Node root) {
//        if(root == null) return 0;
//        int myDia = level(root.left) + level(root.right);
//        int leftDia = diameterOfBinaryTree(root.left);
//        int rightDia = diameterOfBinaryTree(root.right);
//        return Math.max(myDia, Math.max(leftDia, rightDia));
//    }
}