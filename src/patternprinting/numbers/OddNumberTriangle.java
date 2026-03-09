package patternprinting.numbers;

import java.util.Scanner;

public class OddNumberTriangle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the rows of the triangle : ");
        int n = sc.nextInt();
        for(int i=1; i<=n; i++) {
            int a = 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(a + " ");
                a += 2;
            }
            System.out.println();
        }
    }
}
