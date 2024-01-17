package java14;

import java.time.Duration;
import java.util.UUID;


import jdk.jfr.consumer.RecordingStream;

public class JFRRecordingExample {


    public static void main(String[] args) throws InterruptedException {

        var task = new RandomStringGenerator(Thread.currentThread());

        var thread = new Thread(task, "t-random-string");
        thread.start();

        long startTime = System.currentTimeMillis();
        try (var rs = new RecordingStream()) {
            rs.enable("jdk.CPULoad").withPeriod(Duration.ofSeconds(1));
            rs.enable("jdk.GarbageCollection").withPeriod(Duration.ofSeconds(1));
            rs.enable("jdk.GCHeapSummary").withPeriod(Duration.ofSeconds(1));
            rs.enable("jdk.JavaExceptionThrow").withPeriod(Duration.ofSeconds(1));

            rs.onEvent("jdk.CPULoad", event -> {
                System.out.printf("\tCPU load: %f%% - %f%%%n",
                        (event.getFloat("jvmUser") * 100),
                        (event.getFloat("machineTotal") * 100)
                );
            });
            rs.onEvent("jdk.GCHeapSummary", event -> {
                System.out.printf("\tGC - Summary - %s %f MB%n",
                        event.getString("when"),
                        (event.getFloat("heapUsed") / 1_000_000)
                );
            });
            rs.onEvent("jdk.GarbageCollection", event -> {
                System.out.printf("\tGC - Cause %s - Duration: %.04fms%n", event.getString("cause"), (event.getFloat("duration") / 1_000_000));
            });

            rs.onEvent("jdk.JavaExceptionThrow", event -> {
                System.out.printf("\tException Thrown: %s%n", event.getString("thrownClassName"));
            });
            rs.startAsync();

            while (System.currentTimeMillis() - startTime < 60_000) {
                // Keep running for 60 seconds
                Thread.sleep(1000);
            }
        } finally {
            thread.join(); // Ensure the generator thread completes before the program exits
        }
    }
}

class RandomStringGenerator implements Runnable {
    private Thread thread;

    RandomStringGenerator(Thread thread) {
        this.thread = thread;
    }

    public void run() {
        System.out.println("Starting random string generation");
        while (thread.isAlive()) {
            var randomString = generateRandomString();
            System.out.println("Generated random string: " + randomString);

            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Ending random string generation");
    }

    private String generateRandomString() {
        if (Math.random() < 0.33) {
            throw new RuntimeException("Simulated exception in generateRandomString");
        }
        return UUID.randomUUID().toString();
    }
}
