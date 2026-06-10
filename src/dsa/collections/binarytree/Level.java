package dsa.collections.binarytree;

import static dsa.collections.binarytree.Implementation.display;

public class Level {
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
        System.out.println("Total Levels : "+level(a));
    }

    public static int level(Node root) {
        if(root == null){
            return 0;
        }
        return 1 + Math.max(level(root.left), level(root.right));
    }
}