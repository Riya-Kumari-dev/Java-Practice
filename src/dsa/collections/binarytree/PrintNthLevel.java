package dsa.collections.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintNthLevel {
    static class Pair{
        Node node;
        int level;
        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }
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

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the level : ");
        int n = sc.nextInt();
        printNthLevel(a, n);
    }


    // using preorder
//    private static void printNthLevel(Node root, int level) {
//        if(root == null) return;
//        if(level == 0) System.out.print(root.val+" ");
//        printNthLevel(root.left, level-1);
//        printNthLevel(root.right, level-1);
//    }

    // using bfs
    private static void printNthLevel(Node root, int n) {
        if(root == null) return;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair p = q.remove();
            Node temp = p.node;
            int lev = p.level;
            if(lev == n) System.out.print(temp.val + " ");
            if(temp.left != null) q.add(new Pair(temp.left, lev+1));
            if(temp.right != null) q.add(new Pair(temp.right, lev+1));
        }
        System.out.println();
    }
}