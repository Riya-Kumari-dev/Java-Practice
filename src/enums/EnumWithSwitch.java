package enums;

import java.util.Scanner;

enum OrderStatus{
    PLACED, SHIPPED, DELIVERED, CANCELLED
}
public class EnumWithSwitch {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the order status : ");
        String s = sc.next();
        s = s.toUpperCase();
        OrderStatus status = OrderStatus.valueOf(s);

        switch(status){
            case PLACED :
                System.out.println("Your order has been placed successfully.");
                break;
            case SHIPPED :
                System.out.println("Your order has been shipped.");
                break;
            case DELIVERED :
                System.out.println("Your order has been delivered. Thank you for the purchase, we hope to see you soon.");
                break;
            case CANCELLED :
                System.out.println("Your order has been successfully cancelled as per your request.");
                break;
        }
    }
}