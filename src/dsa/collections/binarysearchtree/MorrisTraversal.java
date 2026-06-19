package dsa.collections.binarysearchtree;

import dsa.collections.binarytree.Node;

import java.util.ArrayList;
import java.util.Scanner;

import static dsa.collections.binarytree.ConstructBTUsingBFS.construct;
import static dsa.collections.binarytree.ConstructBTUsingBFS.print;

public class MorrisTraversal {
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
        ArrayList<Integer> ans = inorder(root);
        System.out.println("Inorder : "+ans);
    }

    private static ArrayList<Integer> inorder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Node curr = root;
        while(curr!=null){
            if(curr.left != null){ // left exists
                // find the inorder predecessor of curr
                Node pred = curr.left;
                while(pred.right != null && pred.right != curr){
                    pred = pred.right;
                }
                if(pred.right == null) {
                    pred.right = curr; // linking
                    curr = curr.left;
                }
                else{ // pred.right = null
                    pred.right = null; // unlink
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
            else{ // left does not exist
                ans.add(curr.val);
                curr = curr.right;
            }
        }
        return ans;
    }
}