package java21;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadExample {
    public static void main(String[] args) throws Exception {
        Thread.startVirtualThread(() -> {
            String name = Thread.currentThread().getName();
            System.out.printf("Hello World from virtual Thread called %s!\n", name);
        });


        Thread.ofVirtual()
                .name("Virtual-Thread-From-Builder")
                .start(() -> {
                    String name = Thread.currentThread().getName();
                    System.out.printf("Hello World from virtual Thread called %s!\n", name);
                });


        var threadFactory = Thread.ofVirtual().name("routine-", 0).factory();

        ExecutorService executorService = Executors.newThreadPerTaskExecutor(threadFactory);

        var result = executorService.submit(() -> {
            String name = Thread.currentThread().getName();
            System.out.printf("Hello World from virtual Thread called %s!\n", name);
            return new Random().nextInt(100);
        });
        Thread.sleep(1000);


    }
}
