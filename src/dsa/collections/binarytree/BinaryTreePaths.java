package dsa.collections.binarytree;

import java.util.ArrayList;

public class BinaryTreePaths {
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

        ArrayList<String> paths = binaryTreePaths(a);
        System.out.println(paths);
    }

    private static ArrayList<String> binaryTreePaths(Node root) {
        ArrayList<String> ans = new ArrayList<>();
        helper(root, ans, "");
        return ans;
    }

    private static void helper(Node root, ArrayList<String> ans, String s) {
        if(root == null) return;
        if(root.left == null && root.right == null){ // leaf node
            s+=root.val;
            ans.add(s);
            return;
        }
        s += root.val+"->";
        helper(root.left, ans, s);
        helper(root.right, ans, s);
    }
}