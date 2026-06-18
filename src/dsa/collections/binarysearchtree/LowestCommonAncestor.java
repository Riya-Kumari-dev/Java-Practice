package dsa.collections.binarysearchtree;

import dsa.collections.binarytree.Node;

import static dsa.collections.binarytree.Implementation.display;

public class LowestCommonAncestor {
    static void main(String[] args) {
        Node a = new Node(2);
        Node b = new Node(0);
        Node c = new Node(4);
        Node d = new Node(3);
        Node e = new Node(5);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        display(a);
        System.out.println();
        Node lca = lowestCommonAncestor(a, d, e);
        System.out.println(lca.val);
    }

    private static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        else if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        else return root;
    }
}