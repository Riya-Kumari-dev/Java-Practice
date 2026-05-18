package dsa.collections.linkedlist;

import java.util.Scanner;

public class NextHappyNumber {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        System.out.println(nextHappy(n));
    }
    private static int squareSum(int n){
        int sum = 0;
        while(n>0){
            int rem = n%10;
            sum += rem*rem;
            n/=10;
        }
        return sum;
    }
    private static int nextHappy(int n) {
        // code here
        n++;
        while(true){
            int slow = n;
            int fast = n;
            do{
                slow = squareSum(slow);
                fast = squareSum(squareSum(fast));
            }while(slow != fast);
            if(slow == 1) return n;
            n++;
        }

    }
}