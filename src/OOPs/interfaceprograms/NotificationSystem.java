package OOPs.interfaceprograms;
interface Notification{ // it is like a contract / set of rules => the class implementing that interface must override the abstract methods
    void send(String msg); // public abstract void send(String msg)
}
class Email implements Notification{
    public void send(String msg){
        System.out.println("Email : "+msg);
    }
}
class SMS implements Notification{
    public void send(String msg){
        System.out.println("SMS : "+msg);
    }
}
public class NotificationSystem {
    static void main(String[] args) {
        Notification n = new Email();
        n.send("Hello");

        n = new SMS(); // now it is a referring to SMS class
        n.send("Hi again");
    }
}
