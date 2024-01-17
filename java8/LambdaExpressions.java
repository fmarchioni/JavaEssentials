package java8;

import java.util.Arrays;
import java.util.List;

public class LambdaExpressions {
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
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println( "inside runnable using an anonymous inner class");
            }
        }).start();
    }

    private static void example1() {
        List<String> words = List.of("Bob", "Alice","Charlie");
        words.forEach(name -> System.out.println("Hello, " + name));
    }
}
