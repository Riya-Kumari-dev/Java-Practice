package dsa.collections.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConstructBTUsingBFS {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the levels of the tree : ");
        int l = sc.nextInt();
        int n = (int)Math.pow(2, l) -1;
        int[] arr = new int[n];
        System.out.print("Enter "+n+" elements for the tree (for null please enter '-2147483648') : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Node root = construct(arr, n);
        print(root);
    }

    public static void print(Node root) {
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.remove();
            System.out.print(temp.val+" ");
            if(temp.left != null) q.add(temp.left);
            if(temp.right != null) q.add(temp.right);
        }
        System.out.println();
    }

    public static Node construct(int[] arr, int n) {
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(arr[0]);
        q.add(root);
        int i = 1;
        int j = 2;
        while(!q.isEmpty() && i<n){
            Node temp = q.remove();
            // creation of left right nodes
            Node l;
            Node r;
            if(arr[i] != Integer.MIN_VALUE) l = new Node(arr[i]);
            else l = null;
            if(j!=n && arr[j] != Integer.MIN_VALUE) r = new Node(arr[j]);
            else r = null;
            // place at their positions
            temp.left= l;
            temp.right = r;
            // next iteration
            if(l!=null) q.add(l);
            if(r!=null) q.add(r);
            i+=2;
            j+=2;
        }
        return root;
    }
}