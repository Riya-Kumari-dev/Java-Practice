package dsa.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class BinaryStringWithoutConsecutiveOnes {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        ArrayList<String> finalAns = new ArrayList<>();
        generateBinary(n, "", finalAns);
        System.out.println("Binary strings with "+n+" length having no consecutive ones are : "+finalAns);
    }

    private static void generateBinary(int n, String s, ArrayList<String> finalAns) {
        if(s.length() == n){
            finalAns.add(s);
            return;
        }
        generateBinary(n, s+"0",finalAns);
        if(!s.endsWith("1")) generateBinary(n, s+"1", finalAns);
    }
}