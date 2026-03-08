package ifelse.ternary;

import java.util.Scanner;

public class OddEven {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = sc.nextInt();
//        if(n%2 == 0) System.out.println(n+" is an even number.");
//        else System.out.println(n+" is an odd number.");
        System.out.print(n%2 == 0 ? n+" is even" : n+" is odd");
    }
}
