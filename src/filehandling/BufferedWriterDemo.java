package filehandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {
    public static void main(String[] args) {

        // BufferedWriter wraps FileWriter to provide buffered writing
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("D:\\Riya\\JavaFiles\\books.txt"))) {
            // we can also enable append mode
            /*new BufferedWriter(new FileWriter("books.txt", true));
            * This preserves the existing content and appends new content.*/


            // Write book details
            writer.write("Book ID: 101");
            writer.newLine();

            writer.write("Book Name: Java Programming");
            writer.newLine();

            writer.write("Price: 500");
            writer.newLine();

            System.out.println("Data written successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
        }

        /*When the try-with-resources block finishes:
        Java automatically calls close() on the BufferedWriter.
        close() flushes the remaining buffered data.
        The underlying writer is also closed.*/
    }
}