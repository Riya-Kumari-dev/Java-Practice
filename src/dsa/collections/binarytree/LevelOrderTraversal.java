package dsa.collections.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import static dsa.collections.binarytree.Level.level;

public class LevelOrderTraversal {
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

        ArrayList<ArrayList<Integer>> ans = levelOrderTraversal(a);
        System.out.println(ans);
    }

    // using bfs
    private static ArrayList<ArrayList<Integer>> levelOrderTraversal(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        if(root != null) q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair p = q.remove();
            Node temp = p.node;
            int lev = p.level;
            if(lev == ans.size()){
                ans.add(new ArrayList<>());
            }
            ans.get(lev).add(temp.val); // add the val at that level in ans

            if(temp.left != null) q.add(new Pair(temp.left, lev+1));
            if(temp.right != null) q.add(new Pair(temp.right, lev+1));
        }
        return ans;
    }

    // using dfs
//    private static ArrayList<ArrayList<Integer>> levelOrderTraversal(Node root) {
//        int lev = level(root);
//        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//        for(int i=0; i<lev; i++){
//            ArrayList<Integer> arr = new ArrayList<>();
//            nthLevel(root, i, arr);
//            ans.add(arr);
//        }
//        return ans;
//    }
//
//    private static void nthLevel(Node root, int level, ArrayList<Integer> arr) {
//        if(root == null) return;
//        if(level < 0) return;
//        if(level == 0) arr.add(root.val);
//        nthLevel(root.left, level-1, arr);
//        nthLevel(root.right, level-1, arr);
//    }
}