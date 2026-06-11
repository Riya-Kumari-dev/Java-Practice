package dsa.collections.binarytree;

public class LowestCommonAncestor {
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

        Node ans = lowestCommonAncestor(a, h,i);
        System.out.println(ans.val);
    }

    // all Node.val are unique
    // TC = O(n)
    private static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(p==root || q==root) return root;
        boolean pLiesInLeft = search(root.left, p);
        boolean qLiesInLeft = search(root.left, q);
        if(pLiesInLeft && qLiesInLeft ) return lowestCommonAncestor(root.left, p, q); // both in left
        else if(!pLiesInLeft && !qLiesInLeft) return lowestCommonAncestor(root.right, p, q); // both in right
        else return root; // ek left me hoga aur ek right me koi bhi so root will be lowest common ancestor
    }

    private static boolean search(Node root, Node a) {
        if(root == null) return false;
        if(root.val == a.val) return true;
        return search(root.left, a) || search(root.right, a);
    }
}