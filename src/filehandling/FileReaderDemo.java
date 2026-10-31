package filehandling;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args){
        FileReader reader = null;
        try {
            reader = new FileReader("D:\\Riya\\JavaFiles\\books.txt");
            int data;

            // reader.read()
            // Reads one character at a time and returns its integer value.
            while ((data = reader.read()) != -1) { // read() returns -1 when the end of the file is reached

                // Convert the integer character value into a character
                System.out.print((char) data);
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
        finally{
            // Check whether the reader was successfully initialized
            if (reader != null) {
                try {
                    reader.close();
                    System.out.println("\nReader closed successfully.");

                } catch (IOException e) {
                    System.out.println("Error while closing the reader.");
                }
            }
        }
    }
}