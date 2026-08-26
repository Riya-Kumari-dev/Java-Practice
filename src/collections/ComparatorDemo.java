package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Cricketer{
    String name;
    Double avg;

    public Cricketer(Double avg, String name) {
        this.avg = avg;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cricketer{" +
                "avg=" + avg +
                ", name='" + name + '\'' +
                '}';
    }
}
//class Alpha implements Comparator<Cricketer> {
//    public int compare(Cricketer o1, Cricketer o2){
//        return (int)(o1.avg - o2.avg);
//    }
//}
public class ComparatorDemo {
        /* Comparator :
    -> used to define custom/ external ordering
    * */
    static void main(String[] args) {
        Cricketer c1 = new Cricketer(88.8, "Virat");
        Cricketer c2 = new Cricketer(78.0, "Dhoni");
        Cricketer c3 = new Cricketer(98.0, "Sachin");

        ArrayList<Cricketer> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        System.out.println(list);

        //Alpha a = new Alpha();
        // Collections.sort(list, a);

        // using anonymous inner class
        /*Comparator<Cricketer> c = new Comparator<Cricketer>(){
            @Override
            public int compare(Cricketer o1, Cricketer o2) {
                return (int)(o1.avg - o2.avg);
            }
        };
        Collections.sort(list, c);*/

        // using lambda expression
        Comparator<Cricketer> c = (Cricketer o1, Cricketer o2) -> {
                return (int)(o1.avg - o2.avg);
        };
        Collections.sort(list, c);
        System.out.println(list);

    }
}