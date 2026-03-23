package OOPs.inheritance;
class Vehicle{
    String brand = "Suzuki"; // do
    public void show(){
        System.out.println("Vehicle method");
    }
}
class Car extends Vehicle{
    String name = "Maruti";
    // Overriding
//    default void show(){ // cannot reduce visibility
//        System.out.println("Car Method");
//    }
    public void show(){
        System.out.println("Car Method");
    }

}
public class MethodOverriding {
    static void main(String[] args) {
        Car c = new Car();
        c.show();
    }
}
