package filehandling;

import java.io.PrintWriter;
import java.io.IOException;

public class PrintWriterDemo {
    public static void main(String[] args) {

        // try-with-resources automatically closes the PrintWriter
        try (PrintWriter writer = new PrintWriter("D:\\Riya\\JavaFiles\\books.txt")) {

            // Write book details into the file
            writer.println("Book ID: 101"); // println : Writes data followed by a line separator
            writer.println("Book Name: Java Programming");
            writer.println("Price: 500");

            // printf : Writes formatted data
            writer.printf("Book ID: %d%n", 102);
            writer.printf("Book Name: %s%n", "SpringBoot");
            writer.printf("Price: %.2f%n", 345.0);

            System.out.println("Data written successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
            e.printStackTrace();
        }

        /*We can also append content using FileWriter with PrintWriter.

        try (PrintWriter writer =
                 new PrintWriter(new FileWriter("books.txt", true))) {

            writer.println("Book ID: 102");
            writer.println("Book Name: Spring Boot");
            writer.println("Price: 600");
        }
        Here, FileWriter handles append mode, while PrintWriter provides convenient printing methods.*/
    }
}