package loops.dowhile;

import java.util.Scanner;

public class PrintAtLeast1 {
    static void main(String[] args) {
        System.out.print("Enter number : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i=1;
        do{
            System.out.print(i+" ");
        }while(i>n); // even if the statement false the loop will run atleast once
    }
}
