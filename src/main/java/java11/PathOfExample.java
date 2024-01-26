package java11;

import java.nio.file.Path;

public class PathOfExample {
    public static void main(String[] args) {
        // Creating a Path from a String
        Path pathFromString = Path.of("example.txt");
        System.out.println("Path from String: " + pathFromString);

        // Creating a Path using varargs for multiple path elements
        Path pathWithMultipleElements = Path.of("/home", "francesco", "file.txt");
        System.out.println("Path with Multiple Elements: " + pathWithMultipleElements);

        // Creating a Path from a URI
        Path pathFromURI = Path.of("file:///C:/Users/example.txt");
        System.out.println("Path from URI: " + pathFromURI);

        // Creating a Path from an existing Path
        Path existingPath = Path.of("existing_directory");
        Path newPathFromExisting = existingPath.resolve("new_file.txt");
        System.out.println("Path from Existing Path: " + newPathFromExisting);

        // Creating a Path using getParent() method
        Path childPath = Path.of("parent", "child", "file.txt");
        Path parentPath = childPath.getParent();
        System.out.println("Parent Path: " + parentPath);

        // Creating a Path from a system-dependent String
        String systemDependentPath = "C:\\Users\\example.txt";
        Path systemDependentPathObj = Path.of(systemDependentPath);
        System.out.println("System-Dependent Path: " + systemDependentPathObj);


    }
}
