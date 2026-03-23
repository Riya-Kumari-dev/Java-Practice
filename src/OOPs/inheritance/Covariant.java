package OOPs.inheritance;
class Animal2{

}
class Cat extends Animal2{

}
class Parent3{
    Animal2 getAnimal(){
        return new Animal2();
    }
}
class Children extends Parent3{
    // covariant return type -> Parent -> child relationship
    Cat getAnimal(){
        return new Cat();
    }
}

public class Covariant {
    static void main(String[] args) {
        Children c = new Children();
        Cat c2 = c.getAnimal(); // return new Cat();
    }
}
