package dsa.datastructures.graphs;

import java.util.*;

public class KeysAndRooms {
    /*There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0.
    Your goal is to visit all the rooms.
    However, you cannot enter a locked room without having its key.
    When you visit a room, you may find a set of distinct keys in it.
    Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.*/
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rooms : ");
        int n = sc.nextInt();
        List<List<Integer>> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> arr = new ArrayList<>();
            System.out.print("Number of keys in " + i + "th room are : ");
            int k = sc.nextInt();
            System.out.print("Keys in the "+i+"th room are : ");
            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                arr.add(x);
            }
            rooms.add(arr);
        }
        if(canVisitAllRooms(rooms)) System.out.println("Yes, we can unlock all the rooms.");
        else System.out.println("No, we cannot unlock all the rooms.");
    }

    // TC = O(total number of Keys) or O(vertex + edges)
    // AS = O(n)
    private static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] isVisited = new boolean[n];
        isVisited[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int front = q.remove();
            for(int j=0; j<rooms.get(front).size(); j++){
                int roomKey = rooms.get(front).get(j);
                if(!isVisited[roomKey]){
                    q.add(roomKey);
                    isVisited[roomKey] = true;
                }
            }
        }
        for(int i=0; i<n; i++){
            if(!isVisited[i]) return false;
        }
        return true;
    }
}