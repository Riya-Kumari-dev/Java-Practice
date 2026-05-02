package exceptionhandling;

import java.util.Scanner;

class InvalidUserException extends Exception{
    InvalidUserException(String message){
        super(message); // super() call will go to Exception then from Exception Throwable and sets the message there
    }
}
class Atm{
    private int acc = 125942;
    private int pw = 3402;
    int accountNo;
    int password;
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the account number : ");
        accountNo = sc.nextInt();
        System.out.print("Enter the password : ");
        password = sc.nextInt();
    }
    public void verify()throws InvalidUserException{
        if(accountNo == acc && password == pw){
            System.out.println("Please Proceed Further!");
        }
        else{
            InvalidUserException e = new InvalidUserException("Sorry, seems like you are the wrong person.");
            throw e;
        }
    }
}
class Bank{
    public void initiates(){
        Atm a = new Atm();
        try{
            a.input();
            a.verify();
        }
        catch(InvalidUserException e1){
            System.out.println("Incorrect Credentials, Please Try Again");
            try{
                a.input();
                a.verify();
            }
            catch(InvalidUserException e2){
                System.out.println("Incorrect Credentials, Please Try Again");
                try{
                    a.input();
                    a.verify();
                }
                catch(InvalidUserException e3){
                    System.out.println(e3.getMessage());
                    System.out.println("Blocked");
                }

            }

        }
    }
}
public class CustomException {
    static void main(String[] args) {
        Bank b = new Bank();
        b.initiates();
    }
}
