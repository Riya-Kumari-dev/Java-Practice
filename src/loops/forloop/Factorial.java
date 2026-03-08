package loops.forloop;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        int fact = 1;
        for(int i=2; i<=n; i++){
            fact *= i;
        }
        System.out.print("Factorial of "+n+" is "+fact);
    }
}
