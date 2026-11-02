package filehandling;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    /*FileOutputStream is a class in java.io used to write raw bytes into a file.

    It is useful for:

    Images
    Audio files
    Video files
    PDFs
    Other binary data*/
    public static void main(String[] args) {

        // FileOutputStream
        // Opens the file for writing bytes.
        //If the file doesn't exist, Java attempts to create it.
        // If it already exists, its contents are truncated by default.
        try (FileOutputStream output = new FileOutputStream("D:\\Riya\\JavaFiles\\output.txt")) {

            String message = "Hello Java File Handling!";

            // Convert the String into bytes and write them into the file
            output.write(message.getBytes());

            System.out.println("Data written successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
        }

        /*Just like FileWriter, FileOutputStream also supports append mode.
        new FileOutputStream("output.txt", true);*/
    }
}