package dsa.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static dsa.datastructures.graphs.TopologicalSort.bfs;

public class CourseSchedule {
    /*There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
    You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    Return true if you can finish all courses. Otherwise, return false.

    */
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
        if(canFinish(n, prerequisites)) System.out.println("Yes, we can finish all courses.");
        else System.out.println("No, we cannot finish all courses with the given prerequisites.");
    }

    private static boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            adj.get(edge[0]).add(edge[1]); // directed graph
        }
        int[] inDegree = new int[n];
        for (int i = 0; i<n; i++) {
            for (int ele : adj.get(i)) {
                inDegree[ele]++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        bfs(inDegree, adj, ans);
        return ans.size() == n;
    }
}