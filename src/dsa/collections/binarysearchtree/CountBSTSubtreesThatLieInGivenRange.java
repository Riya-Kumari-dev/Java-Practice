package dsa.collections.binarysearchtree;

import dsa.collections.binarytree.Node;

import java.util.Scanner;

import static dsa.collections.binarytree.ConstructBTUsingBFS.construct;
import static dsa.collections.binarytree.ConstructBTUsingBFS.print;

public class CountBSTSubtreesThatLieInGivenRange {
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
        System.out.print("Enter the range : ");
        int lo = sc.nextInt();
        int hi = sc.nextInt();

        System.out.print("There are total of "+countSubtrees(root, lo, hi)+" subtrees that lie in range "+lo+" to "+hi);
    }

    static int ans;
    private static int countSubtrees(Node root, int lo, int hi) {
        ans = 0;
        isSubtreeInRange(root, lo, hi);
        return ans;
    }

    private static boolean isSubtreeInRange(Node root, int lo, int hi) {
        if(root == null) return true;
        boolean left = isSubtreeInRange(root.left, lo, hi);
        boolean right = isSubtreeInRange(root.right, lo, hi);

        if(root.val >= lo && root.val <= hi && left && right) {
            ans++;
            return true;
        }
        return false;
    }
}