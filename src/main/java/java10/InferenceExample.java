package java10;

import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class InferenceExample {

    public static void main(String[] args) {
        // Example 1
        var number = 10;  // Inferred type: int

        // Example 2
        var list = new ArrayList<String>();    // infers ArrayList<String>
        var stream = list.stream();            // infers Stream<String>
        var fileName = "example.txt";
        try {
            var tempPath = Files.createTempFile(fileName, null);
            var bytes = Files.readAllBytes(tempPath);  // infers byte[]


            // Delete the temporary file
            Files.delete(tempPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Example 3
        var opt = Optional.of("Value"); // Optional<String>

        // Example 4
        for (var counter = 0; counter < 10; counter++)  {
            //...   // infers int
        }

        // Example 5
        var runnable = (Runnable) () -> System.out.println("Running...");

        // Example 6
        Map<String, List<String>> map = new HashMap<>();
        var key = "key";
        var value = "value";
        map.computeIfAbsent(key, (var k) -> new ArrayList<>()).add(value);
    }
}
