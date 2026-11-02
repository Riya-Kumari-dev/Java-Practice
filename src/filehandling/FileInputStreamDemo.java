package filehandling;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    /*FileInputStream is particularly useful for binary files, such as:

    🖼️ Images
    🎵 Audio files
    🎬 Video files
    📄 PDF files*/

    public static void main(String[] args) {

        try (FileInputStream input = new FileInputStream("D:\\Riya\\JavaFiles\\books.txt")) { // Opens a file for reading raw bytes.

            int data;

            // Read bytes until the end of the file
            while ((data = input.read()) != -1) {
                // read()
                // Returns:
                //A byte value in the range 0–255.
                //-1 when the end of the file is reached.

                // Convert the byte value into a character for this ASCII text example
                System.out.print((char) data);
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}