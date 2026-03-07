package ifelse;

import java.util.Scanner;

public class MagnitudeOfNumberSmallerThan54 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer : ");
        int n = sc.nextInt();
        sc.close();
        int orig = n;
        if(n<0) n = -n;
        if(n<69) System.out.print("Yes, the magnitude of "+orig+" is smaller than 54");
        else System.out.print("No, the magnitude of "+orig+" is not smaller than 54");
    }
}
