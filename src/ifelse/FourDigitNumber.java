package ifelse;

import java.util.Scanner;

public class FourDigitNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive number : ");
        int n = sc.nextInt();
        sc.close();
        if(n>999 && n<10000) System.out.println(n+" is a four digit number.");
        else System.out.println(n+" is not a four digit number.");
    }
}
