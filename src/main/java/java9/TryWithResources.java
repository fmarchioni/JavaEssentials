package java9;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class TryWithResources {
    public static void main(String[] args) {
        try {
            // Create two temporary files in the home directory
            Path fromPath = Files.createTempFile(Path.of(System.getProperty("user.home")), "tempFrom", ".txt");
            Path toPath = Files.createTempFile(Path.of(System.getProperty("user.home")), "tempTo", ".txt");

            // Declare final variables
            final InputStream inStream;
            final OutputStream outStream;

            try {
                inStream = Files.newInputStream(fromPath);
                outStream = Files.newOutputStream(toPath);

                try (inStream; outStream) {
                    // Buffer to read data in chunks
                    byte[] buffer = new byte[1024];
                    int bytesRead;

                    // Read from the input stream and write to the output stream
                    while ((bytesRead = inStream.read(buffer)) != -1) {
                        outStream.write(buffer, 0, bytesRead);
                    }

                    System.out.println("File copied successfully!");
                }
            } catch (IOException e) {
                // Handle exceptions
                e.printStackTrace();
            } finally {
                // Delete the temporary files when done
                Files.deleteIfExists(fromPath);
                Files.deleteIfExists(toPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
