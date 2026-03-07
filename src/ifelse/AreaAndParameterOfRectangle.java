package ifelse;

import java.util.Scanner;

public class AreaAndParameterOfRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the rectangle : ");
        double l = sc.nextDouble();
        System.out.print("Enter the breadth of the rectangle : ");
        double b = sc.nextDouble();
        double area = l*b;
        double perimeter = 2*(l+b);
        if(area>perimeter) System.out.println("Area of the given rectangle is greater than its perimeter.");
        else if(perimeter == area) System.out.println("The given rectangle has equal area and perimeter.");
        else System.out.println("Perimeter of the given rectangle is greater than its area.");
    }
}
