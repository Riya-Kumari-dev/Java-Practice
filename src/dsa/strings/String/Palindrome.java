package dsa.strings.String;

import java.util.Scanner;

public class Palindrome {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string : ");
        String s = sc.nextLine();
        int i=0;
        int j=s.length()-1;
        boolean flag  = true;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                flag = false;
                break;
            }
            i++;
            j--;
        }
        if(flag) System.out.println("Yes, "+s+" is a palindrome");
        else System.out.println("No, "+s+" is not a palindrome.");
    }
}
