package java8;

import java.util.Arrays;
import java.util.List;

public class LambdaExample2 {
    public static void main(String[] args) {

        example1();
        example2();
        example3();


    }

    private static void example3() {
        List<String> words = Arrays.asList("Apple", "Banana", "Orange", "Grapes");
        words.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
    }


    private static void example2() {
        Runnable myRunnable = () -> {
            // Code to be executed in the new thread
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread: " + i);
            }
        };
        new Thread(myRunnable).run();

    }

    private static void example1() {
        List<String> words = List.of("Bob", "Alice","Charlie");
        words.forEach(name -> System.out.println("Hello, " + name));
    }
}
