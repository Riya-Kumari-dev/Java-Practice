package dsa.collections.binarytree;

public class PathSum {
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

        int target = 14;
        if(hasPathSum(a, target)) System.out.println("Yes ");
        else System.out.println("No");
    }

    private static boolean hasPathSum(Node root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null){ // we are on leaf node
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);
    }
}