package dsa.collections.binarytree;

public class DFSTraversals {
    static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(-1);
        Node e = new Node(1);
        Node f = new Node(6);
        Node g = new Node(9);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        System.out.print("Preorder : ");
        preorder(a);
        System.out.println();
        System.out.print("Inorder : ");
        inorder(a);
        System.out.println();
        System.out.print("Postorder : ");
        postorder(a);
        System.out.println();
        System.out.println();
        System.out.print("Reverse Preorder : ");
        revPreorder(a);
        System.out.println();
        System.out.print("Reverse Inorder : ");
        revInorder(a);
        System.out.println();
        System.out.print("Reverse Postorder : ");
        revPostorder(a);
        System.out.println();

    }
    private static void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    private static void preorder(Node root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);

    }
    private static void postorder(Node root) {
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    private static void revPreorder(Node root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        revPreorder(root.right);
        revPreorder(root.left);
    }

    private static void revInorder(Node root) {
        if(root == null) return;
        revInorder(root.right);
        System.out.print(root.val + " ");
        revInorder(root.left);
    }

    private static void revPostorder(Node root) {
        if(root == null) return;
        revPostorder(root.right);
        revPostorder(root.left);
        System.out.print(root.val + " ");
    }
}