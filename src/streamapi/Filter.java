package streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

    /* Stream
    -> introduced in Java 8
    ->  a stream can only be operated on or traversed exactly once
    -> Allows processing of data without modifying the original collection.
    -> Supports parallel processing to improve performance on large datasets.
    -> Reduces the need for lengthy loops and temporary variables in code.*/
public class Filter {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(20,30,10,50));

        Stream<Integer> stream = list.stream();


        // filter()
        // Returns a stream consisting of the elements of this stream that match the given predicate.

        /*Predicate<Integer> p = new Predicate<>(){

            @Override
            public boolean test(Integer n) {
                return n>20;
            }
        };
        Stream<Integer> fil = stream.filter(p);*/

        Stream<Integer> fil2 = stream.filter(n -> n > 20);
        fil2.forEach(n-> System.out.println(n));
    }
}