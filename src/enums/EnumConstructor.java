package enums;

enum Laptop{
    DELL(80000),
    HP(70000),
    MACBOOK(150000);

    private final int price;

    Laptop(int price){ // called 3 times , as when the enum is initialized all three constants are initialized, so the constructor executes 3 times
        this.price = price;
        System.out.println("Constructor called for "+this.name());
    }
    public int getPrice(){
        return price;
    }
}
public class EnumConstructor {
    static void main(String[] args) {
        System.out.println("Accessing enum...");
        Laptop laptop = Laptop.MACBOOK;
        System.out.println("Selected laptop is "+laptop);
        System.out.println("Price of "+laptop+" is Rs "+laptop.getPrice());
    }
}