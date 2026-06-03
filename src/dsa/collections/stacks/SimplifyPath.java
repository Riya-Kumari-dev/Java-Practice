package dsa.collections.stacks;

import java.util.Scanner;
import java.util.Stack;

public class SimplifyPath {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the path as Unix file system : ");
        String path = sc.next();
        String simple = simplifyPath(path);
        System.out.println(path);
        System.out.println(simple);
    }

    private static String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> st = new Stack<>();
        for(int i=0; i<arr.length; i++){
            String t = arr[i];
            // ignore if size is zero => because of /
            // ignore the single period also because it means current directory
            if(t.isEmpty() || t.equals(".")) continue;
            else if(t.equals("..")){
                if(!st.isEmpty())  st.pop(); // go one folder back
            }
            else{
                st.push(t); // normal directory
            }
        }
        // join
        String ans = "/" + String.join("/", st);
        return ans;
    }
}