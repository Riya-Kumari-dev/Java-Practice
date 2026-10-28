package streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEach {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

        // printing
        System.out.println(list);

        for(int i=0; i<list.size(); i++){ // normal for loop
            System.out.print(list.get(i)+" ");
        }

        System.out.println();
        for(int ele : list){ // enhanced for loop
            System.out.print(ele+" ");
        }
        System.out.println();
        Consumer<Integer> con = new Consumer<>(){
            @Override
            public void accept(Integer n) {
                System.out.println(n);
            }
        };
        list.forEach(con); // forEach using anonymous inner class

        System.out.println();

        list.forEach(n -> System.out.println(n)); // forEach using lambda expression

        System.out.println();

        list.forEach(System.out::println); // forEach using method reference
    }
}