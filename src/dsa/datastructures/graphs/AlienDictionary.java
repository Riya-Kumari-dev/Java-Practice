package dsa.datastructures.graphs;

import java.util.Scanner;
import java.util.*;

public class AlienDictionary {
    /*An alien language uses the lowercase English alphabet, but the order of its letters is unknown.
    You are given an array of strings words[] that is claimed to be sorted lexicographically according to the rules of the alien language.

    Determine the order of the letters in the alien alphabet.
    If a valid ordering exists, return a string containing all unique letters in lexicographical order according to the alien language.
    Otherwise, return an empty string.*/

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total number of words : ");
        int n = sc.nextInt();
        String[] words = new String[n];
        System.out.print("Enter " + n + " words for the given array : ");
        for(int i=0; i<n; i++){
            words[i] = sc.next();
        }
        System.out.println("Alien order for "+Arrays.toString(words)+" is "+findOrder(words));
    }

    private static String findOrder(String[] words) {
        List<List<Character>> adj = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i<26; i++) {
            adj.add(new ArrayList<>());
        }
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                set.add(ch);
            }
        }
        int[] inDegree = new int[26];
        for (int i = 0; i<words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLength = Math.min(w1.length(), w2.length());
            int j = 0;
            while (j<minLength) {
                char ch = w1.charAt(j);
                char dh = w2.charAt(j);
                if (ch != dh) {
                    // Avoid duplicate edge
                    if (!adj.get(ch-'a').contains(dh)) {
                        adj.get(ch-'a').add(dh);
                        inDegree[dh - 'a']++;
                    }
                    break;
                }
                j++;

            }
            if (j == minLength && w1.length() > w2.length()) {
                return "";
            }
        }
        return bfs(adj, inDegree, set);
    }
    private static String bfs(List<List<Character>> adj, int[] inDegree, HashSet<Character> set) {
        Queue<Character> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < inDegree.length; i++) {
            char ch = (char)(i + 'a');
            if (inDegree[i] == 0 && set.contains(ch)) {
                q.add(ch);
            }
        }
        while (!q.isEmpty()) {
            char front = q.remove();
            ans.append(front);
            for (char ch : adj.get(front-'a')) {
                inDegree[ch - 'a']--;
                if (inDegree[ch - 'a'] == 0 && set.contains(ch)) {
                    q.add(ch);
                }
            }
        }
        // Cycle exists
        if (ans.length() != set.size()) {
            return "";
        }
        return ans.toString();
    }
}