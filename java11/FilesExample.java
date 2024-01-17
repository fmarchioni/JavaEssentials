package java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FilesExample {
    public static void main(String[] args) throws Exception {
        // Example file path
        Path filePath = Path.of("example.txt");

        // Example content to write to the file
        String contentToWrite = "Hello, Java 11!";

        // Writing a string to a file using Files.writeString()
        Files.writeString(filePath, contentToWrite);

        // Reading content from a file using Files.readString()
        String contentRead = Files.readString(filePath);

        // Appending content to a file using Files.writeString()
        String additionalContent = "\nAppending more content!";
        Files.writeString(filePath, additionalContent, StandardOpenOption.APPEND);

    }
}
