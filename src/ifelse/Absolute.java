package ifelse;

import java.util.Scanner;

public class Absolute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = sc.nextInt();
        int orig = n;
        if(n<0) n = -n;
        System.out.print("Absolute of "+orig+" is "+n);
    }
}
