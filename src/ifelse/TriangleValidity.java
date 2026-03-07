package ifelse;

import java.util.Scanner;

public class TriangleValidity {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the sides of the triangle : ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        if((a+b) > c && (b+c)>a && (a+c)>b) System.out.println("Yes, it is a valid triangle.");
        else System.out.println("No, it is not valid triangle.");
    }
}
