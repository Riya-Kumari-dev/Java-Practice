package patternprinting.shapes;

import java.util.Scanner;
public class Curtain {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows : ");
        int n = sc.nextInt();
        for(int i=1; i<=2*n-1; i++){
            System.out.print('*'+" ");
        }
        System.out.println();
        int nsp = 1; // number of spaces
        int nst = n-1; // number of stars
        for(int i=1; i<n; i++) {
            for(int j=1; j<=nst; j++){
                System.out.print('*'+" ");
            }
            for(int j=1; j<=nsp; j++){
                System.out.print("  ");
            }
            nsp+=2;
            for(int j=1; j<=nst; j++){
                System.out.print('*'+" ");
            }
            nst--;
            System.out.println();
        }
    }
}
