package filehandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        try (
                FileInputStream input = new FileInputStream("D:\\Riya\\JavaFiles\\books.txt"); // FileInputStream reads bytes from the source file.
                FileOutputStream output = new FileOutputStream("D:\\Riya\\JavaFiles\\backup.txt") // FileOutputStream writes bytes into the destination file.
        ) {

            int data;

            // Read one byte at a time
            while ((data = input.read()) != -1) {

                // Write the byte into destination file
                output.write(data);
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}