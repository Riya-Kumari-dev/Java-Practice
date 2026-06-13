package dsa.collections.binarytree;

import java.util.ArrayList;

import static dsa.collections.binarytree.Level.level;

public class RightSideView {
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

        int n = level(a);
        ArrayList<Integer> rightView = new ArrayList<>();
        for(int k=0; k<n;k++) rightView.add(0);
        rightSideView(a, rightView, 0);
        System.out.println("Right View : " + rightView);
    }

    private static void rightSideView(Node root, ArrayList<Integer> ans, int lev) {
        if(root == null) return;
        ans.set(lev, root.val);
        rightSideView(root.left, ans,lev+1);
        rightSideView(root.right, ans, lev+1);
    }
}