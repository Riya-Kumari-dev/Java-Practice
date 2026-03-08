package loops.forloop;

import java.util.Scanner;

public class PrimeFactors {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        System.out.print("Factors of "+n+" : ");
        for(int i=1; i<=Math.sqrt(n); i++){
            if(n%i==0) System.out.print(i+" ");
        }
        for(int i=(int)Math.sqrt(n); i>=1; i--){
            if(n%i==0 && i!=n/i) System.out.print(n/i+" ");
        }
    }
}
