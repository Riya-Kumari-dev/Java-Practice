package filehandling;

import java.io.File;
import java.io.IOException;

public class FileInformation {
    public static void main(String[] args) {

        File file = new File("D:\\Riya\\JavaFiles\\student2.txt");

        try {
            // Create the file if it does not exist
            if (file.createNewFile()) {
                System.out.println("File created successfully.");
            }

            // Check whether the file exists
            System.out.println("Exists: " + file.exists());

            // Get the file name
            System.out.println("Name: " + file.getName());

            // Get the absolute path
            System.out.println("Absolute Path: " + file.getAbsolutePath());

            // Check whether the file can be read
            System.out.println("Readable: " + file.canRead());

            // Check whether the file can be written to
            System.out.println("Writable: " + file.canWrite());

            // Get the file size in bytes
            System.out.println("Size: " + file.length());

            // Check whether the path represents a regular file
            System.out.println("Is File: " + file.isFile());

            // Check whether the path represents a directory
            System.out.println("Is Directory: " + file.isDirectory());

            System.out.println(file.delete());

        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}