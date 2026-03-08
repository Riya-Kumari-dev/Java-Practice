package loops.forloop;

import java.util.Scanner;

public class AP {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of terms : ");
        int n = sc.nextInt();
        for(int i=1, a=2; i<=n; i++, a+=3){
            System.out.print(a+" ");
        }
    }
}
