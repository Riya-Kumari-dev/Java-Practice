package loops.forloop;

import java.util.Scanner;

public class FibonacciSeries {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of terms : ");
        int n = sc.nextInt();
        int t1 = 1;
        int t2 = 1;
        if(n>=1) System.out.print(t1+" ");
        if(n>=2) System.out.print(t2+" ");
        int sum = 0;
        for(int i=3; i<=n; i++){
            sum = t1 + t2;
            t1 = t2;
            t2 = sum;
            System.out.print(sum+" ");
        }
    }
}
