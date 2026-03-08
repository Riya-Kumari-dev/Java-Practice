package loops.forloop;

import java.util.Scanner;

public class Power {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the base : ");
        int a = sc.nextInt();
        System.out.print("Enter the exponent : ");
        int b = sc.nextInt();
        int pow = 1;
        for(int i=1; i<=b; i++){
            pow *= a;
        }
        if(a == 0 && b==0) System.out.print("Not defined.");
        else System.out.println(a+" raised to the power "+b+" is "+pow);
    }
}
