package enums;

interface Payment{
    void displayMessage();
}
enum PaymentStatus implements Payment{
    PENDING{
        public void displayMessage(){
            System.out.println("Please wait for a while, the payment is pending.");
        }
    }, SUCCESS{
        public void displayMessage(){
            System.out.println("Congratulations, successfully paid");
        }
    }, FAILED{
        public void displayMessage(){
            System.out.println("Sorry, the transaction is failed due to technical glitch. We will resolve it soon.");
        }
    };

}
public class PaymentStatusDemo {
    static void main(String[] args) {
        Payment status = PaymentStatus.SUCCESS;
        status.displayMessage();

        status = PaymentStatus.FAILED;
        status.displayMessage();
    }
}