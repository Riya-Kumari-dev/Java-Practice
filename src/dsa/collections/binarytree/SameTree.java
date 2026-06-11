package dsa.collections.binarytree;

import static dsa.collections.binarytree.Implementation.display;

public class SameTree {
    static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);

        a.left = b;
        a.right = c;
        c.left = d;

        Node g = new Node(1);
        Node h = new Node(2);
        Node i = new Node(3);
        Node j = new Node(4);

        g.left = h;
        g.right = i;
        i.left = j;

        display(a);
        System.out.println();
        display(g);

        System.out.println();
        boolean flag = isSame(a,g);
        if(flag) System.out.println("Both Trees are same.");
        else System.out.println("Both Trees are not same.");
    }

    public static boolean isSame(Node root1, Node root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2==null) return false;
        if(root1.val != root2.val) return false;
        if(!isSame(root1.left, root2.left)) return false;
        return isSame(root1.right, root2.right);
    }
}