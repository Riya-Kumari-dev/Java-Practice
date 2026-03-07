package ifelse;

import java.util.Scanner;

public class CheckInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a real number : ");
        double n = sc.nextDouble();
        int x = (int)n;
        if(n==x) System.out.print(n+" is an Integer");
        else System.out.print(n+" is not an Integer, it is a fractional number");
    }
}
