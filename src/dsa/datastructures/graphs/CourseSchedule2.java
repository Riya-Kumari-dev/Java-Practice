package dsa.datastructures.graphs;

import java.util.*;

import static dsa.datastructures.graphs.TopologicalSort.bfs;

public class CourseSchedule2 {
    /*There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
    You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them.
    If it is impossible to finish all courses, return an empty array.*/
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of courses : ");
        int n = sc.nextInt();
        System.out.print("Enter the length of prerequisites : ");
        int m = sc.nextInt();
        int[][] prerequisites = new int[m][2];
        System.out.println("Enter the prerequisites data : ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                prerequisites[i][j] = sc.nextInt();
            }
        }
        System.out.println("Ordering of courses we should take to finish all the courses is "+ Arrays.toString(findOrder(n, prerequisites)));
    }

    private static int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for (int[] edge : prerequisites) {
            adj.get(edge[0]).add(edge[1]); // directed graph
            inDegree[edge[1]]++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        bfs(inDegree, adj, ans);
        Collections.reverse(ans);
        int[] finalAns = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            finalAns[i] = ans.get(i);
        }
        if(finalAns.length != n) return new int[0];
        return finalAns;
    }
}