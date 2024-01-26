package java11;

import java.util.ArrayList;
import java.util.List;

public class CollectionToArrayExample {
    public static void main(String[] args) {
        // Create a list of strings
        List<String> stringList = List.of("Java", "is", "awesome!");

        // Convert the list to an array using the toArray(IntFunction<A[]> generator) method
        String[] stringArray = stringList.toArray(String[]::new);

        // Print the elements of the array
        for (String element : stringArray) {
            System.out.println(element);
        }
    }
}
