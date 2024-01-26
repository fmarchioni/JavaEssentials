package java21;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;

public class StructuredConcurrencyExample {
    private String calcutateInParallel(String str) throws InterruptedException, ExecutionException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {

            StructuredTaskScope.Subtask<String> digest1 = scope.fork(() -> this.getDigest("MD5", str));
            StructuredTaskScope.Subtask<String> digest2 = scope.fork(() -> this.getDigest("SHA-256", str));

            scope.join();
            scope.throwIfFailed();

            return digest1.get() + digest2.get();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new StructuredConcurrencyExample().calcutateInParallel("HelloWorld!");
    }

    private String getDigest(String digest, String str) throws Exception {
        System.out.printf("Calculating %s Digest for string : %s \n", digest, str);
        MessageDigest md = MessageDigest.getInstance(digest);
        return new String(md.digest(str.getBytes(StandardCharsets.UTF_8)));

    }
}
        