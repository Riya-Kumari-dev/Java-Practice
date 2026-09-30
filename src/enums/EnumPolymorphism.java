package enums;

interface Message{
    void show();
}
enum Status implements Message{
    RUNNING, FAILED;
    public void show(){
        System.out.println("Status : "+this.name());
    }
}
public class EnumPolymorphism {
    static void main(String[] args) {
        Message m = Status.RUNNING;
        m.show();

        m = Status.FAILED;
        m.show();
    }
}