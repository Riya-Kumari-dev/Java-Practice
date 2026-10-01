package annotations.builtin;

/* @Deprecated
- It is a built-in Java annotation.
_ It marks a class, method, field, constructor, etc. as outdated or discouraged for new code.
- Sometimes a library provides an old method and later introduces a better replacement.
- We don't always remove the old method immediately because existing programs may still depend on it.

@Deprecated tells the developer :
- This feature still exists, but prefer the newer alternative.

@Deprecated does not prevent the feature from being used. It generally causes a compiler / IDE warning.
*/

class Calculator{

    @Deprecated(since = "2.0", forRemoval = true) // since -> specifies the version since which the feature was deprecated.
    // forRemoval -> If true, indicates that the feature is intended to be removed in the future.
    void oldCalculate(){
        System.out.println("Old calculation");
    }
    void newCalculate(){
        System.out.println("New calculation");
    }

}
public class DeprecatedDemo {
    static void main(String[] args) {
        Calculator cal = new Calculator();

        cal.oldCalculate(); // this method is deprecated, so the compiler show a deprecation warning. But run successfully.

        cal.newCalculate(); // preferred method for new code
    }
}