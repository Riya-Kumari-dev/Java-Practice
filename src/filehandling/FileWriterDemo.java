package filehandling;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void main(String[] args) {

        // try-with-resources automatically closes the FileWriter
        try (FileWriter writer = new FileWriter("D:\\Riya\\JavaFiles\\books.txt")) {

            // Writes character data to the file.
            writer.write(100 ); // store as 'd'
            writer.write("Book ID: 101\n"); // The \n character represents a line break.
            writer.write("Book Name: Java Programming\n");
            writer.write("Price: 500\n");

            System.out.println("Data written successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }

        // true enables append mode
        try (FileWriter writer = new FileWriter("D:\\Riya\\JavaFiles\\books.txt", true)) {

            // Append another book to the existing file
            writer.write("Book ID: 102\n");
            writer.write("Book Name: Spring Boot\n");
            writer.write("Price: 600\n");

            System.out.println("Data appended successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred while appending data.");
        }
    }
}