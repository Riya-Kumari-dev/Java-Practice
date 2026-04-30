package dsa.strings.String;

import java.util.Scanner;

public class CountVowels {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string : ");
        String s = sc.nextLine();
        int i=0;
        int count =0;
        while(s.length()>i){
            if(s.charAt(i) == 'a' || s.charAt(i) =='e' || s.charAt(i) == 'i' || s.charAt(i) =='o'  || s.charAt(i) =='u')
                count++;
            i++;
        }
        System.out.println("Total number of vowels in the given string is : "+count);
    }
}
