package filehandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {
    public static void main(String[] args) {

        // BufferedReader reads data efficiently using an internal buffer
        // BufferedReader wraps another Reader and adds buffering functionality.
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\Riya\\JavaFiles\\books.txt"))) {

            String line;

            // Read one complete line at a time
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}