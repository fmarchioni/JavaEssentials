package java8;

import java.util.function.*;

public class FunctionsOpsExample {
    public static void main(String[] args) {
        // Consumer: Print a String
        Consumer<String> stringPrinter = (s) -> System.out.println(s);
        stringPrinter.accept("Hello, World!");

        // Supplier: Generate a random number
        Supplier<Double> randomNumberSupplier = () -> Math.random();
        double randomValue = randomNumberSupplier.get();
        System.out.println("Random Number: " + randomValue);

        // Predicate: Check if a number is even
        Predicate<Integer> isEven = (n) -> n % 2 == 0;
        boolean isEvenResult = isEven.test(5);
        System.out.println("Is 5 even? " + isEvenResult);

        // Function: Convert an Integer to String
        Function<Integer, String> intToStringConverter = (i) -> "Number is: " + i;
        String convertedString = intToStringConverter.apply(10);
        System.out.println("Converted String: " + convertedString);

        // BiFunction: Add two integers
        BiFunction<Integer, Integer, Integer> adder = (a, b) -> a + b;
        int sumResult = adder.apply(5, 7);
        System.out.println("Sum of 5 and 7: " + sumResult);

        // UnaryOperator: Square a number
        UnaryOperator<Integer> square = num -> num * num;
        int squaredResult = square.apply(5);
        System.out.println("Square of 5: " + squaredResult);

        // BinaryOperator: Multiply two numbers
        BinaryOperator<Integer> multiplier = (a, b) -> a * b;
        int multiplyResult = multiplier.apply(4, 7);
        System.out.println("Product of 4 and 7: " + multiplyResult);
    }
}
