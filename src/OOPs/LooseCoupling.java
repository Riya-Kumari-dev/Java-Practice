package OOPs;
interface iDeliveryService{
    Boolean DeliverProduct(Double amount);
}
class FirstFlight implements iDeliveryService{
    public Boolean DeliverProduct(Double amount){
        System.out.println("Product Delivered by FirstFlight and amount paid is "+amount);
        return true;
    }
}
class EKart implements iDeliveryService{
    public Boolean DeliverProduct(Double amount){
        System.out.println("Product Delivered by EKart and amount paid is "+amount);
        return true;
    }
}
class Amazon{ // target class
    private iDeliveryService service;
    // constructor injection
    public Amazon(iDeliveryService service){
        this.service = service;
    }
    public Amazon(){

    }
    // setter injection
    public void setService(iDeliveryService service){ // 35. iDeliveryService service = new FirstFlight();
        this.service = service;
    }
    public Boolean isDeliver(Double amount){
        return service.DeliverProduct(amount);
    }
}
public class LooseCoupling { // inversion of control
    static void main(String[] args) {
        Amazon a = new Amazon();
        a.setService(new FirstFlight());
        if(a.isDeliver(5000.0)== true){
            System.out.println("Product delivered successfully");
        }
        else{
            System.out.println("Failed to deliver");
        }

        Amazon b = new Amazon(new EKart());
        if(b.isDeliver(3478.34) == true){
            System.out.println("Product delivered successfully");
        }
        else{
            System.out.println("Failed to deliver");
        }
    }
}
