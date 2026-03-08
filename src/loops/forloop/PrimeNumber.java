package loops.forloop;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        boolean flag = true; // true means prime
        // if i is a factor of n then n/i will also be a factor of n
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0){
                flag = false;
                break;
            }
        }
        if(n==1) System.out.println(n+" is neither prime nor composite.");
        else if(!flag) System.out.println(n+" is a composite number.");
        else System.out.println(n+" is a prime number.");
    }
}
