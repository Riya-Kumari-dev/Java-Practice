package dsa.collections.binarytree;

import java.util.ArrayList;
import java.util.Scanner;

import static dsa.collections.binarytree.Implementation.display;

public class PathSum3 {
    static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(-1);
        Node e = new Node(1);
        Node f = new Node(6);
        Node g = new Node(9);
        Node h = new Node(10);
        Node i = new Node(6);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = h;
        e.right = i;

        display(a);
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter target : ");
        int target = sc.nextInt();

        int paths = pathSum(a, target);
        System.out.println(paths);
    }

    // return the number of paths where the sum of the values along the path equals targetSum.
    //The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
    private static int pathSum(Node root, int target) {
        if(root == null) return 0;
        // root se bhi ho sakta hai and non root se bhi
        return helper(root, target) + pathSum(root.left, target) + pathSum(root.right, target);
    }

    private static int helper(Node root, long target) {
        if(root == null) return 0;
        int count = 0;
        if(root.val == target) count++;
        count += helper(root.left, target-root.val) + helper(root.right, target-root.val);
        return count;
    }
}