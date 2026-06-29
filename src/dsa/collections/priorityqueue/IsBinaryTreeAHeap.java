package dsa.collections.priorityqueue;

import dsa.collections.binarytree.Node;

import static dsa.collections.binarytree.Implementation.display;

public class IsBinaryTreeAHeap {
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
        if(isMaxHeap(a)) System.out.println("Yes, the given binary tree is a maxHeap");
        else System.out.println("No, the given binary tree is not a maxHeap");
    }
    static int size;
    private static boolean isMaxHeap(Node root) {
        if(root == null) return true;
        int leftval = root.left != null ? root.left.val : Integer.MIN_VALUE;
        int rightval = root.right != null ? root.right.val : Integer.MIN_VALUE;
        if(root.val <= leftval || root.val <= rightval) return false;
        return isMaxHeap(root.left) && isMaxHeap(root.right);
    }
    public int Size(Node root){
        if(root == null) return 0;
        return 1 + Size(root.left) + Size(root.right);
    }
    public boolean isCBT(Node root, int idx){
        if(root == null) return true;
        if(idx > size) return false;
        return isCBT(root.left, 2*idx) && isCBT(root.right, 2*idx+1);
    }
    public boolean isHeap(Node root) {
        // code here
        size = Size(root);
        return isMaxHeap(root) && isCBT(root, 1);
    }
}