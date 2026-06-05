package dsa.collections.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WinnerOfCircularGame {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of friends playing the game : ");
        int n = sc.nextInt();
        System.out.print("Enter steps i.e. k : ");
        int k = sc.nextInt();
        int winner = findTheWinner(n, k);
        System.out.print("Winner is "+winner+"th friend");
    }

//    The rules of the game are as follows:
//
//    Start at the 1st friend.
//    Count the next k friends in the clockwise direction including the friend you started at.
//    The counting wraps around the circle and may count some friends more than once.
//    The last friend you counted leaves the circle and loses the game.
//    If there is still more than one friend in the circle,
//    go back to step 2 starting from the friend immediately clockwise of the friend who just lost and repeat.
//    Else, the last friend in the circle wins the game.
    private static int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        // add n friends to queue
        for(int i=1; i<=n; i++) q.add(i);

        // now start the game
        while(q.size()>1){ // winner ek hi hoga
            for(int i=1; i<k; i++){ // first k-1 friends bach jayenge
                q.add(q.remove());
            }
            // kth friend will lose the game
            q.remove();
        }
        return q.peek();
    }
}