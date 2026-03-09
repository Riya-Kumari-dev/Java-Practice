package patternprinting.shapes;

import java.util.Scanner;

public class Pyramid {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows : ");
        int n = sc.nextInt();
        int nsp = n-1; // number of spaces
        int nst = 1; // number of stars
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=nsp; j++){
                System.out.print("  ");
            }
            nsp--;
            for (int j = 1; j <= nst; j++) {
                System.out.print('*' + " ");
            }
            nst+=2;
            System.out.println();
        }
    }
}
