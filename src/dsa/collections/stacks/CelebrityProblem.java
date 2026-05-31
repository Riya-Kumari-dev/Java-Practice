package dsa.collections.stacks;

import java.util.Scanner;
import java.util.Stack;

public class CelebrityProblem {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons : ");
        int m = sc.nextInt();
        int n = m/2;
        int[][] arr = new int[n][n];
        System.out.print("Enter the celebrity value of each person : ");
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int celeb = celebrity(arr);
        if(celeb == -1) System.out.println("No celebrity found.");
        else System.out.println(celeb+"th person is the celebrity.");
    }


    // a celebrity is a person who is known by everyone and does not know anyone
    //  if an element of row i and column j is set to 1 it means ith person knows jth person

    // using stack => O(n) TC
    private static int celebrity(int[][] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            st.push(i);
        }
        while(st.size() > 1){
            int i=st.pop();
            int j = st.pop();
            boolean iCeleb = true;
            boolean jCeleb = true;
            if(arr[i][j] == 1){ // i knows j => i is not celebrity
                iCeleb = false;
            }
            else{ // arr[i][j] == 0 => i don't know j => j cannot be celebrity
                jCeleb = false;
            }
            if(arr[j][i] == 1) { // j knows i => j is not celebrity
                jCeleb = false;
            }
            else { // arr[j][i] == 0 j don't know i => i is not celebrity
                iCeleb = false;
            }
            if(iCeleb) st.push(i);
            if(jCeleb) st.push(j);
        }
        if(st.isEmpty()) return -1;// no celebrity found
        int celeb = st.pop();
        for(int j=0; j<n; j++){
            if(j==celeb) continue; // khud ko to janta hi hai
            if(arr[celeb][j] == 1) return -1; // celebrity kisi ko janta hai => no celebrity
        }
        for(int i=0; i<n; i++){
            if(i==celeb) continue;
            if(arr[i][celeb] == 0) return -1; // someone don't know celebrity
        }
        return celeb;
    }

    // brute force => O(n^2)
//    private static int celebrity(int[][] arr) {
//        int n = arr.length;
//        for(int i=0; i<n; i++){
//            boolean isCelebrity = true;
//            for(int j=0; j<n; j++){
//                if(i==j) continue; // khud ko to janta hi hai
//                // arr[i][j] == 1 => i knows someone => no celebrity
//                // arr[j][i] = 0 => someone does not know i => no celebrity
//                if(arr[i][j] == 1 || arr[j][i] == 0){
//                    isCelebrity = false;
//                    break;
//                }
//            }
//            if(isCelebrity) return i;
//        }
//        return -1;
//    }
}