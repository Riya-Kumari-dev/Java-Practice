package dsa.collections.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class IterativeDFS {
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

        ArrayList<Integer> pre = preorder(a);
        System.out.println(pre);
        ArrayList<Integer> post = postorder(a);
        System.out.println(post);
        ArrayList<Integer> in = inorder(a);
        System.out.println(in);
    }

    // TC = O(n) , SC = O(n) , AS = O(log(n)) , worst case AS = O(n)
    private static ArrayList<Integer> inorder(Node root) {
        Stack<Node> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Node temp = root;
        while(true){
            // if temp is not null => push into stack and go left
            if(temp != null){
                st.push(temp);
                temp = temp.left;
            }
            else{ // null encounters
                if(st.isEmpty()) break;
                Node top = st.pop();
                ans.add(top.val);
                temp = top.right; // top ke left wale sare add ho gye honge so go right
            }
        }
        return ans;
    }

    // TC = O(n), AS = O(log(n)) => O(h) => where h is the height of the tree
    private static ArrayList<Integer> preorder(Node root) {
        Stack<Node> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(root != null) st.push(root);
        while(!st.isEmpty()){
            Node temp = st.pop();
            ans.add(temp.val);
            // last in first out => so left node should insert last
            if(temp.right != null) st.push(temp.right);
            if(temp.left != null) st.push(temp.left);
        }
        return ans;
    }

    // TC = O(n) , AS = O(n)
    private static ArrayList<Integer> postorder(Node root) {
        Stack<Node> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(root != null) st.push(root);
        while(!st.isEmpty()){
            Node temp = st.pop();
            // reverse preorder
            ans.add(temp.val);
            if(temp.left != null) st.push(temp.left);
            if(temp.right != null) st.push(temp.right);
        }
        // reverse preorder = reverse(postorder)
        Collections.reverse(ans);
        return ans;
    }
}