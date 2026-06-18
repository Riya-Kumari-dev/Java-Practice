package dsa.collections.binarysearchtree;

import dsa.collections.binarytree.Node;

import java.util.Scanner;

import static dsa.collections.binarytree.ConstructBTUsingBFS.construct;
import static dsa.collections.binarytree.ConstructBTUsingBFS.print;

public class ShortestDistanceBetweenTwoNodes {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the levels of the tree : ");
        int l = sc.nextInt();
        int n = (int) Math.pow(2, l) - 1;
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the tree (for null please enter '-2147483648') : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Node root = construct(arr, n);

        print(root);
        System.out.print("Enter the two nodes value from the tree : ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("Shortest distance between the given nodes is "+shortestDistance(root, a, b));
    }

    private static int shortestDistance(Node root, int a, int b) {
        Node LCA = lowestCommonAncestor(root, a, b);
        int[] dis = {0,0};
        dfs(LCA, a, b, 0, dis);
        return dis[0]+dis[1];

    }
    private static void dfs(Node root, int a, int b, int depth, int[] dis) {
        if(root == null) return;
        // nodes match => then mark the dist from the lca
        if(root.val == a) dis[0] = depth;
        if(root.val == b) dis[1] = depth;
        dfs(root.left, a, b, depth+1, dis);
        dfs(root.right, a, b, depth+1, dis);
    }
    private static Node lowestCommonAncestor(Node root, int p, int q) {
        if(root.val < p && root.val < q) return lowestCommonAncestor(root.right, p, q);
        else if(root.val > p && root.val > q) return lowestCommonAncestor(root.left, p, q);
        else return root;
    }
}