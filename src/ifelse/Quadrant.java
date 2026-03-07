package ifelse;

import java.util.Scanner;

public class Quadrant {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the coordinates of the point : ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        if(x>0 && y>0) System.out.println("("+x+","+y+") lies in the first quadrant.");
        else if(x<0 && y>0) System.out.println("("+x+","+y+") lies in the second quadrant.");
        else if(x<0 && y<0) System.out.println("("+x+","+y+") lies in the third quadrant.");
        else if(x>0 && y<0) System.out.println("("+x+","+y+") lies in the fourth quadrant.");
        else if(x==0 && y==0) System.out.println("("+x+","+y+") lies on the origin.");
        else if(x==0) System.out.println("("+x+","+y+") lies on y-axis.");
        else System.out.println("("+x+","+y+") lies on x-axis.");
    }
}
