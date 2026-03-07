package ifelse;

import java.util.Scanner;

public class GreatestOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers : ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        if(a>b){
            if(a>c) System.out.println(a+" is greatest.");
            else System.out.println(c+" is greatest.");
        }
        else{
            if(b>c) System.out.println(b+" is greatest.");
            else System.out.println(c+" is greatest.");
        }
    }
}
