package collections.generics;

class Generics<T>{ // T is called a type parameter
    private T ref;
    public Generics(T ref){
        this.ref = ref;
    }

    public void display(){
        System.out.println("The type of T is "+ref.getClass().getName());
    }

    public T getRef() {
        return ref;
    }
}
public class GenericClass {
    static void main(String[] args) {
        Generics<Integer> g = new Generics<>(44);
        g.display();
        System.out.println(g.getRef());

        Generics<String> g2 = new Generics<>("Riya");
        g2.display();
        System.out.println(g2.getRef());
    }
}