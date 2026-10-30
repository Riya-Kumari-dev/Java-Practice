package filehandling;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {

        // Create a File object representing the file path
        File file = new File("D:\\Riya\\JavaFiles\\student.txt"); // it does not create the actual file on the disk.

        try {
            // file.createNewFile()
//            This attempts to create the actual file.
//            Returns true if a new file is created.
//            Returns false if the file already exists.
            if (file.createNewFile()) {
                System.out.println("File created successfully!");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
        }
    }
}