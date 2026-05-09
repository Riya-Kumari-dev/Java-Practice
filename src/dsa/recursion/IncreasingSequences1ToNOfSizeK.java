package dsa.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class IncreasingSequences1ToNOfSizeK {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        System.out.print("Enter k : ");
        int k = sc.nextInt();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        sequence(1, n, k, new ArrayList<>(), ans);
        System.out.println("Increasing sequence of first "+n+" natural numbers of size "+k+" are "+ans);
    }

    private static void sequence(int i, int n, int k, ArrayList<Integer> a, ArrayList<ArrayList<Integer>> ans) {
        if(a.size()==k){
            ans.add(new ArrayList<>(a));
            return;
        }
        if(i>n) return;
        // take
        a.add(i);
        sequence(i+1, n, k, a, ans);
        a.removeLast();
        // skip
        sequence(i+1, n, k,a, ans);
    }
}