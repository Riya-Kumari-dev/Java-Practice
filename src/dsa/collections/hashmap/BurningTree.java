package dsa.collections.hashmap;

import dsa.collections.binarytree.Node;

import java.util.*;

import static dsa.collections.binarytree.ConstructBTUsingBFS.construct;
import static dsa.collections.binarytree.ConstructBTUsingBFS.print;

public class BurningTree {
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

        System.out.print("Enter the burning node value : ");
        int target = sc.nextInt();
        System.out.println("Minimum time to burn the tree is "+minTime(root, target)+"sec");
    }

    static class Pair{
        Node node;
        int level;
        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }
    static Node start;
    static HashMap<Node, Node> parent;
    private static int minTime(Node root, int target) {
        // find the parent of each node except the root
        parent = new HashMap<>(); // for node and its parent

        // find the node with value equals to target
        start = null;
        find(target, root);

        // hashset for already burnt nodes
        HashSet<Node> burnt = new HashSet<>();

        // make queue with starting root as temp
        Queue<Pair> q = new LinkedList<>();
        // node, time
        q.add(new Pair(start,0));
        burnt.add(start);
        int minTime = 0;
        while(!q.isEmpty()){
            Pair pair = q.remove();
            Node node = pair.node;
            int time = pair.level;
            minTime = Math.max(minTime, time); // min time is max level, which is time here

            // parent is burning
            if(parent.containsKey(node) && !burnt.contains(parent.get(node))) {
                q.add(new Pair(parent.get(node), time+1));
                burnt.add(parent.get(node));
            }
            // root.left is burning
            if(node.left != null && !burnt.contains(node.left))  {
                q.add(new Pair(node.left, time+1));
                burnt.add(node.left);
            }
            // root.right is burning
            if(node.right != null && !burnt.contains(node.right)) {
                q.add(new Pair(node.right, time+1));
                burnt.add(node.right);
            }
        }
        return minTime;
    }

    private static void find(int target, Node root) {
        if(root == null) return;
        if(root.val == target) {
            start = root;
            return;
        }
        if(root.left != null){
            parent.put(root.left, root);
        }
        if(root.right != null){
            parent.put(root.right, root);
        }
        find(target, root.left);
        find(target, root.right);
    }
}