package java8;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalExamples {

    public static void main(String[] args) {
        // Example 1: Optional.empty()
        Optional<String> emptyOptional = Optional.empty();

        // Example 2: Optional.of(value)
        String value = "Hello";
        Optional<String> nonNullOptional = Optional.of(value);

        // Example 3: Optional.ofNullable(nullableValue)
        String nullableValue = null;
        Optional<String> nullableOptional = Optional.ofNullable(nullableValue);

        // Example 4: orElse
        String resultOrElse = nonNullOptional.orElse("Default");
        System.out.println("Result from orElse: " + resultOrElse);

        // Example 5: orElseThrow
        try {
            String resultOrElseThrow = emptyOptional.orElseThrow(() ->
                    new NoSuchElementException("Value not present"));
            System.out.println("Result from orElseThrow: " + resultOrElseThrow);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        // Example 6: orElseGet
        String resultOrElseGet = Optional.ofNullable(value).orElseGet(() -> defaultValue());
        System.out.println("Result from orElseGet: " + resultOrElseGet);

        // Example 7: ifPresent
        nonNullOptional.ifPresent(val -> System.out.println("Value is present: " + val));

        // Example 8: map
        Optional<Integer> length = Optional.of("Value").map(String::length);
        System.out.println("Length of the value: " + length.orElse(0));

        // Example 9: flatMap
        Optional<String> flatMapped =  Optional.of("Value").flatMap(val -> Optional.of(val.toUpperCase()));
        System.out.println("FlatMapped value: " + flatMapped.orElse(""));

        // Example 10: filter
        Optional<String> filtered = Optional.of("Value").filter(val -> val.startsWith("H"));
        System.out.println("Filtered value: " + filtered.orElse(""));

        // Example 11: customFilter
        Optional<String> customFiltered = Optional.of("Value").filter(val -> val != null && val.length() > 5);
        System.out.println("Custom filtered value: " + customFiltered.orElse(""));

        // Example 12: combined
        Optional<String> combined = Optional.of("Value").flatMap(val -> Optional.of(val + " World"));
        System.out.println("Combined value: " + combined.orElse(""));

        // Example 13: customCombined
        Optional<String> customCombined = Optional.of("Hello").flatMap(val -> {
            if (val.contains("Hello")) {
                return Optional.of(val + "!");
            } else {
                return Optional.empty();
            }
        });
        System.out.println("Custom combined value: " + customCombined.orElse(""));


    }

    private static String defaultValue() {
        return "Default Value";
    }
}
