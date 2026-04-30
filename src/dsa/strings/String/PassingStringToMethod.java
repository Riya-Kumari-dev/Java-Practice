package dsa.strings.String;

import java.util.Scanner;

public class PassingStringToMethod {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string : ");
        String s = sc.nextLine();
        System.out.println(s);
        change(s);
        System.out.println(s);
    }
    static void change(String x){ // pass by value
        x = "Uttrakhand";
    }
}
