package dsa.collections.binarytree;

import java.util.ArrayList;
import java.util.Scanner;

import static dsa.collections.binarytree.Implementation.display;

public class PathSum2 {
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

        ArrayList<ArrayList<Integer>> paths = pathSum(a, target);
        System.out.println(paths);
    }

    // return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
    // Each path should be returned as a list of the node values, not node references.
    private static ArrayList<ArrayList<Integer>> pathSum(Node root, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        helper(root, target, ans, arr);
        return ans;
    }

    private static void helper(Node root, int target, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> arr) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null){
            if(target == root.val){
                arr.add(root.val);
                ans.add(arr);
            }
            return;
        }
        arr.add(root.val);
        // pass the deep copy of arr two left and right
        ArrayList<Integer> arr1 = new ArrayList<>(arr);
        ArrayList<Integer> arr2 = new ArrayList<>(arr);

        helper(root.left, target-root.val, ans, arr1);
        helper(root.right, target-root.val, ans, arr2);
    }
}