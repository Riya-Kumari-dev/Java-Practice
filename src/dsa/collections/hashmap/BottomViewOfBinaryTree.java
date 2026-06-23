package dsa.collections.hashmap;

import dsa.collections.binarytree.Node;

import java.util.*;

import static dsa.collections.binarytree.ConstructBTUsingBFS.construct;
import static dsa.collections.binarytree.ConstructBTUsingBFS.print;

public class BottomViewOfBinaryTree {
    static class Pair{
        int level;
        Node node;
        Pair(int level, Node node){
            this.level = level;
            this.node = node;
        }
    }
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

        System.out.println("Bottom view : "+topView(root));
    }

    private static ArrayList<Integer> topView(Node root) {
        // map for levels and value of node
        HashMap<Integer, Integer> m = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        // use bfs for traversal
        Queue<TopViewOfBinaryTree.Pair> q = new LinkedList<>();
        q.add(new TopViewOfBinaryTree.Pair(0, root));
        // max min for adding correctly like from left to right
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            TopViewOfBinaryTree.Pair pair = q.remove();
            Node temp = pair.node;
            int level = pair.level;
            m.put(level, temp.val);
            min = Math.min(min, level);
            max = Math.max(max, level);
            if(temp.left != null) { // left side level - 1
                TopViewOfBinaryTree.Pair t = new TopViewOfBinaryTree.Pair(level-1,temp.left);
                q.add(t);
            }
            if(temp.right != null){ // right side level+1
                TopViewOfBinaryTree.Pair t = new TopViewOfBinaryTree.Pair(level+1,temp.right);
                q.add(t);
            }
        }
        for(int i=min; i<=max; i++){
            ans.add(m.get(i));
        }
        return ans;
    }
}