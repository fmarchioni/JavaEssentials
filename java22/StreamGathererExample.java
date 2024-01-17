package java22;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamGathererExample {
    public static void main(String args[]) {

        // Will contain [[1, 2, 3], [4, 5, 6], [7, 8,9]]
/*
        List<List<Integer>> windows = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .gather(Gatherers.windowFixed(3))
                .toList();

        Optional<String> numberString =
                Stream.of(1,2,3,4,5,6,7,8,9)
                        .gather(
                                Gatherers.fold(() -> "", (string, number) -> string + number)
                        )
                        .findFirst();

 */
    }
}
