package dsa.collections.binarytree;

import static dsa.collections.binarytree.Implementation.display;
import static dsa.collections.binarytree.InvertBinaryTree.invert;
import static dsa.collections.binarytree.Mirror.isMirror;
import static dsa.collections.binarytree.SameTree.isSame;

public class SymmetricTree {
    static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(2);
        Node d = new Node(3);
        Node e = new Node(4);
        Node f = new Node(4);
        Node g = new Node(3);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        display(a);
        System.out.println();
        boolean flag = isSymmetric(a);
        if(flag) System.out.println("The given tree is symmetric.");
        else System.out.println("The given tree is not symmetric.");
//        a.left = invert(a.left);
//        display(a);
    }

    private static boolean isSymmetric(Node root) {
        return isMirror(root.left, root.right);
    }


    // line 30 is for this one because here the inversion happens so we have to get the old version back
//    private static boolean isSymmetric(Node root) {
//        return isSame(invert(root.left), root.right);
//    }
}