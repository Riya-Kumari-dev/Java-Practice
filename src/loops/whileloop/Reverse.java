package loops.whileloop;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        int orig = n;
        int rev = 0;
        while(n!=0){
            rev*=10;
            rev += (n%10);
            n/=10;
        }
        System.out.println("The reverse of "+orig+" is "+rev);
    }
}
