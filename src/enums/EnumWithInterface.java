package enums;

interface Printable{
    void print();
}
enum StatusMessage implements Printable{
    RUNNING, SUCCESS, FAILED;

    public void print(){
        System.out.println("Current status : " + this.name());
    }
}
public class EnumWithInterface {
    static void main(String[] args) {
        StatusMessage status = StatusMessage.SUCCESS;
        status.print(); // Current status : SUCCESS
    }
}