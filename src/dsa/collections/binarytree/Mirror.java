package dsa.collections.binarytree;

import static dsa.collections.binarytree.Implementation.display;

public class Mirror {
    static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);

        a.left = b;
        a.right = c;
        c.left = d;

        Node g = new Node(1);
        Node h = new Node(3);
        Node i = new Node(2);
        Node j = new Node(4);

        g.left = h;
        g.right = i;
        h.right = j;

        display(a);
        System.out.println();
        display(g);

        System.out.println();
        if(isMirror(a, g)) System.out.println("Both tree are mirror image of each other.");
        else System.out.println("Both are not mirror image of each other");
    }

    public static boolean isMirror(Node root1, Node root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }
}