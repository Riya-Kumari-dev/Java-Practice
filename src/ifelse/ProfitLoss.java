package ifelse;

import java.util.Scanner;

public class ProfitLoss {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the selling price of the product : ");
        double sp = sc.nextDouble();
        System.out.print("Enter the cost price of the product : ");
        double cp = sc.nextDouble();
        if((sp-cp) > 0) System.out.print("Profit earned : "+(sp-cp));
        else if((sp-cp) < 0) System.out.print("Loss : "+(cp-sp));
        else System.out.print("We have not earned any profit nor loss.");
    }
}
