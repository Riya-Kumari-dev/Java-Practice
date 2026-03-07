package ifelse;

import java.util.Scanner;

public class Divisibility {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer : ");
        int n = sc.nextInt();
        if(n%5==0 && n%3==0) System.out.println(n+" is divisible by both 5 and 3.");
        else if(n%5==0) System.out.println(n+" is divisible by 5.");
        else if(n%3==0) System.out.println(n+" is divisible by 3.");
        else System.out.println(n+" is neither divisible by 5 nor 3.");
    }
}
