package java9;
import java.util.*;

public class ImmutableCollectionsExample {
    public static void main(String[] args) {
        // Creating an immutable List
        List<Integer> immutableList = List.of(1, 2, 3, 4, 5);

        // Error: Adding to an immutable List
        // listOf.add(6); // java.lang.UnsupportedOperationException

        // Error: Removing from an immutable List
        // listOf.remove(0); // java.lang.UnsupportedOperationException

        // Error: Modifying an element in an immutable List
        // listOf.set(0, 0); // java.lang.UnsupportedOperationException

        // Creating an immutable Set
        Set<Integer> immutableSet = Set.of(1, 2, 3, 4, 5);

        // Creating an immutable Map
        Map<String, String> immutableMap = Map.of(
                "Key1", "Value1",
                "Key2", "Value2");

        // Printing elements from immutable List
        immutableList.forEach(System.out::println);

        // Printing key-value pairs from immutable Map
        immutableMap.forEach((key, value) -> System.out.println(key + " -> " + value));

        // Creating a modifiable List from an array
        List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5);

        // Error: Adding to a fixed-size List
        // asList.add(6); // java.lang.UnsupportedOperationException

        // Error: Removing from a fixed-size List
        // asList.remove(0); // java.lang.UnsupportedOperationException

        // Modifying an element in a fixed-size List is allowed
        asList.set(0, 0);

        // Creating an immutable List from a mutable List
        List<String> mutableList = Arrays.asList("Apple", "Pear", "Peach");
        List<String> copyImmutableList = List.copyOf(mutableList);

        // Error: Modifying an element in an immutable List
        // copyImmutableList.set(0, "Banana"); // java.lang.UnsupportedOperationException

        List unmodifList = Collections.unmodifiableList(new ArrayList<>() {{
            add("Apple"); add("Orange"); add("Banana");
        }});

        Map unmodMap = Collections.unmodifiableMap(new HashMap<String, Integer>() {{
            put("key",1);
        }});

        // Error: Modifying a fixed-size Map
        // fixedSizeMap.put("Key1", 1); // java.lang.UnsupportedOperationException
    }
}
