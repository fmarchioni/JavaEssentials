package java8;



import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsIntermediateOpsExample {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);

        // Original list of numbers
        System.out.println("Original List of Numbers: " + numbers);

        // Filter numbers greater than 3
        List<Integer> filteredNumbers = numbers.stream()
                .filter(num -> num > 3)
                .collect(Collectors.toList());
        printList("Filtered Numbers (greater than 3):", filteredNumbers);

        // Square each number
        List<Integer> squaredNumbers = numbers.stream()
                .map(num -> num * num)
                .collect(Collectors.toList());
        printList("Squared Numbers:", squaredNumbers);

        // Sort the numbers
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        printList("Sorted Numbers:", sortedNumbers);

        // Get distinct numbers
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        printList("Distinct Numbers:", distinctNumbers);

        // Limit to the first 4 numbers
        List<Integer> limitedNumbers = numbers.stream()
                .limit(4)
                .collect(Collectors.toList());
        printList("Limited Numbers (First 4):", limitedNumbers);

        // Skip the first 3 numbers
        List<Integer> skippedNumbers = numbers.stream()
                .skip(3)
                .collect(Collectors.toList());
        printList("Skipped Numbers (After skipping 3):", skippedNumbers);

        // Calculate the sum of all numbers
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum of all numbers: " + sum);
    }

    private static <T> void printList(String label, List<T> list) {
        System.out.println(label + " " + list);
    }
}
