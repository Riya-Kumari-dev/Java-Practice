package filehandling;

import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PrintStreamDemo {
    public static void main(String[] args) {

        // PrintStream wraps FileOutputStream
        // FileOutputStream provides the connection to the file through byte output.
        //PrintStream provides convenient printing methods.
        try (PrintStream output = new PrintStream(new FileOutputStream("D:\\Riya\\JavaFiles\\books.txt"))) {

            // Write book details
            output.println("Book ID: 101");
            output.println("Book Name: Java Programming");
            output.println("Price: 500");

            // Write formatted data
            output.printf("Discount: %.2f%n", 50.0);

            System.out.println("Data written successfully!");
            /*System is a class.
            out is a static field of System.
            out is an object of PrintStream.
            println() is a method of PrintStream.*/

        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
            e.printStackTrace();
        }

        /*We can also append data:

        new PrintStream(
            new FileOutputStream("books.txt", true)
        );

        Here, the FileOutputStream handles append mode.*/
    }
}