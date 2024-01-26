package java17;
import java.time.Instant;
import java.time.Clock;
import java.time.InstantSource;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class InstantSourceExample {

    public static void main(String[] args) {

        Clock clock = Clock.systemUTC();
        Instant now = clock.instant();
        System.out.println("Current timestamp: " + now);

        // Parse a string that represents an instant
        Instant instantText = Instant.parse("2024-01-01T11:10:34.243715Z");
        // Add one Hour to the current time
        Instant oneHourLater = now.plus(1, ChronoUnit.HOURS);
        // Subtract 30 seconds from the current instant
        Instant thirtySecondsEarlier = now.minus(30, ChronoUnit.SECONDS);




    }
}
