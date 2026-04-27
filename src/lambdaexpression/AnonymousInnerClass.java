package lambdaexpression;
class A{
    public void show(){
        System.out.println("Outer class");
    }
}
public class AnonymousInnerClass {
    static void main(String[] args) {
        A obj = new A(){
            public void show(){
                System.out.println("Anonymous Inner Class");
            }
            public void greet(){
                System.out.println("Hey, Good Evening");
            }
        };
        obj.show();
        //obj.greet(); // cannot access because reference type is A

        // can access using anonymous object, but we have to declare it again
        new A(){
            public void show(){
            System.out.println("Anonymous Inner Class");
            }
            public void greet(){
                System.out.println("Hey, Good Evening");
            }
        }.greet();
    }
}
