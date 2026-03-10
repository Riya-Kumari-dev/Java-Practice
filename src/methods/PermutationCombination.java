package methods;

import java.util.Scanner;

public class PermutationCombination {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        System.out.print("Enter r : ");
        int r = sc.nextInt();
        System.out.println(n+"P"+r+" = "+permutation(n, r));
        System.out.println(n+"C"+r+" = "+combination(n, r));
    }
    static int fact(int n){
        int f = 1;
        for(int i=2; i<=n; i++){
            f*=i;
        }
        return f;
    }
    static int permutation(int n, int r){
        return fact(n)/fact(n-r);
    }
    static int combination(int n, int r){
        return fact(n)/(fact(r)*fact(n-r));
    }
}
