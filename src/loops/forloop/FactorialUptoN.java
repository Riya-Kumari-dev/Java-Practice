package loops.forloop;

import java.util.Scanner;

public class FactorialUptoN {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of terms : ");
        int n = sc.nextInt();
        int fact = 1;
        for(int i=1; i<=n; i++){
            fact *= i;
            System.out.println("Factorial of "+i+" : "+fact);
        }
    }
}
