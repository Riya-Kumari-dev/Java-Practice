package annotations.builtin;

/* @SuppressWarnings
- built-in Java annotation.
- It tells the compiler :
    - I am aware of this warning, so don't show this particular warning here.
- @SuppressWarnings does not fix the problem, it only suppresses the warning.
- Therefore, it should be used carefully and only when we understand why the warning is occurring.

- Common warning types :
    - "unchecked" -> Suppresses the unchecked operation warnings.
    - "rawtypes" -> Suppresses raw type warnings.
    - "deprecation" -> Suppresses deprecated API warnings.
*/

import java.util.ArrayList;

public class SuppressWarningsDemo {
    static void main(String[] args) {
        // Raw type :
        // Normally, we should specify the generic type.
        // Using a raw type can generate a compiler warning.
        @SuppressWarnings("rawtypes")
        ArrayList list = new ArrayList();
        list.add("Java");
        list.add("Python");

        // Unchecked Warning :
        // here we assign a raw Arraylist to a parameterized ArrayList<String>
        // the compiler cannot guarantee that every element in the raw list is actually a String.
        @SuppressWarnings("unchecked")
        ArrayList<String> arr = list;
        System.out.println(arr);

    }
}