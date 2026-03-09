package patternprinting.shapes;

import java.util.Scanner;

public class Cross {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows (odd) : ");// for cross printing the rows and columns must be odd
        int n = sc.nextInt();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j || j==n+1-i) System.out.print('*'+" ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }
}
