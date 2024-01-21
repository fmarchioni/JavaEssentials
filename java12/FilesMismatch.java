package java12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesMismatch {

    static Path createTempPath(String fileName) throws IOException {
        Path tempPath = Files.createTempFile(fileName, ".txt");
        tempPath.toFile().deleteOnExit();

        return tempPath;
    }

    public static void main(String[] args) throws IOException {

        Path filePath1 = createTempPath("file1");
        Path filePath2 = createTempPath("file2");

        Files.writeString(filePath1, "It was a dark and stormy night");
        Files.writeString(filePath2, "It was a dark and stormy night");


        long mismatch = Files.mismatch(filePath1, filePath2);
        System.out.println(mismatch == -1 ? "Files identical" : "Files different");


    }
}