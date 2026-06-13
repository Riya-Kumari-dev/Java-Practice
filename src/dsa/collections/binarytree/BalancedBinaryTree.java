package dsa.collections.binarytree;

import static dsa.collections.binarytree.Level.level;

public class BalancedBinaryTree {
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

        if(isBalanced(a)) System.out.println("Yes, the given tree is balanced.");
        else System.out.println("No, the given tree is not balanced.");
    }

    // TC = O(n)
    private static boolean isBalanced(Node root) {
        boolean[] ans = {true}; // to mark whether the tree is balanced or not
        levels(root, ans);
        return ans[0];
    }

    private static int levels(Node root, boolean[] ans) {
        if(root == null){
            return 0;
        }
        int leftLevel = levels(root.left, ans);
        int rightLevel = levels(root.right, ans);

        // now find the diff between left levels and right levels
        int diff = Math.abs(leftLevel- rightLevel);
        // if diff is greater than 1 then mark the ans[0] as false => not a balanced binary tree
        if(diff>1) ans[0] = false;

        return 1 + Math.max(leftLevel, rightLevel);
    }

    // TC = O(n^2)
//    private static boolean isBalanced(Node root) {
//        if(root == null) return true;
//        int diff = Math.abs(level(root.left) - level(root.right));
//        if(diff > 1) return false;
//        return isBalanced(root.left) && isBalanced(root.right);
//    }
}