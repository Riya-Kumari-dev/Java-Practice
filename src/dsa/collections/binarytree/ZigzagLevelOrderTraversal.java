package dsa.collections.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZigzagLevelOrderTraversal {
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

        ArrayList<ArrayList<Integer>> ans = zigzagLevelOrderTraversal(a);
        System.out.println(ans);

        ArrayList<Integer> arr = zigzag(a);
        System.out.println(arr);
    }

    // Store in 1d arraylist
    private static ArrayList<Integer> zigzag(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        ArrayList<Integer> currLevel = new ArrayList<>();
        int currentLevel = 0;

        while(!q.isEmpty()) {
            Pair p = q.remove();
            Node temp = p.node;
            int lev = p.level;

            // Level changed
            if(lev != currentLevel) {
                ans.addAll(currLevel);
                currLevel = new ArrayList<>();
                currentLevel = lev;
            }

            if(lev % 2 == 0) {
                currLevel.add(temp.val);
            } else {
                currLevel.addFirst(temp.val);
            }

            if(temp.left != null) q.add(new Pair(temp.left, lev + 1));
            if(temp.right != null) q.add(new Pair(temp.right, lev + 1));
        }

        // Add last level
        ans.addAll(currLevel);

        return ans;
    }

    // in 2D arraylist
    private static ArrayList<ArrayList<Integer>> zigzagLevelOrderTraversal(Node root) {
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
            if(lev % 2 == 0) ans.get(lev).add(temp.val); // for even level normally insert
            else ans.get(lev).addFirst(temp.val);  // but for odd levels insert at front so the result observed reversed

            if(temp.left != null) q.add(new Pair(temp.left, lev+1));
            if(temp.right != null) q.add(new Pair(temp.right, lev+1));
        }
        return ans;
    }
}