package filehandling;

import java.io.File;

public class DirectoryDemo {
    public static void main(String[] args) {

        File directory = new File("D:\\Riya\\JavaFiles\\Books");

        // Create directory
        // mkdir() : creates a single directory, parent must exists
        // mkdirs() : creates nested directories, creates missing parents
        if (directory.mkdir()) {
            System.out.println("Directory created successfully");
        } else {
            System.out.println("Directory already exists or creation failed");
        }

        // Check whether it is a directory
        if (directory.isDirectory()) {
            System.out.println("It is a directory");

            // List files and subdirectories
            String[] files = directory.list();

            if (files != null) {
                for (String name : files) {
                    System.out.println(name);
                }
            }
        }

        // Delete directory (works only if empty)
        // directory.delete();
    }
}