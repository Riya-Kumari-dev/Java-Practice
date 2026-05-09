package dsa.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GenerateParentheses {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        int n = sc.nextInt();
        ArrayList<String> finalAns = new ArrayList<>();
        generate(n,"",finalAns, 0, 0);
        System.out.println("valid parentheses having n = "+n+" are "+finalAns);
    }

    private static void generate(int n, String ans, ArrayList<String> finalAns, int op, int cl) {
        if(ans.length() == n*2){
            finalAns.add(ans);
            return;
        }
        if(op<n){
            generate(n, ans+"(", finalAns, op+1, cl);
        }
        if(op>cl){
            generate(n, ans+")", finalAns, op, cl+1);
        }
    }
}