package dsa.collections.priorityqueue;

import dsa.collections.binarytree.Node;

import java.util.ArrayList;

import static dsa.collections.binarytree.Implementation.display;

public class BSTtoMaxHeap {
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
        convertToMaxHeap(a);
        display(a);
    }
    static int idx;
    private static void convertToMaxHeap(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        reverseInorder(root, ans);
        idx = 0;
        preOrder(root, ans);
    }

    private static void preOrder(Node root, ArrayList<Integer> ans) {
        if(root == null) return;
        root.val = ans.get(idx++);
        preOrder(root.left, ans);
        preOrder(root.right, ans);
    }

    private static void reverseInorder(Node root, ArrayList<Integer> ans) {
        if(root == null) return;
        reverseInorder(root.right, ans);
        ans.add(root.val);
        reverseInorder(root.left, ans);
    }
}