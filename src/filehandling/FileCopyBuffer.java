package filehandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyBuffer {
    public static void main(String[] args) {

        try (
                FileInputStream input = new FileInputStream("D:\\Riya\\JavaFiles\\books.txt");

                FileOutputStream output = new FileOutputStream("D:\\Riya\\JavaFiles\\backup.txt")
        ) {

            byte[] buffer = new byte[1024]; // Creates an array that can hold 1024 bytes at a time.

            int bytesRead;

            // Reads bytes into the array and returns the number of bytes actually read, or -1 at EOF.
            while ((bytesRead = input.read(buffer)) != -1) {

                // Write only the bytes that were actually read
                output.write(buffer, 0, bytesRead);
                // This method accepts three arguments:
                //buffer: The byte array.
                //0: Starting position in the array.
                //bytesRead: Number of bytes to write.
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}