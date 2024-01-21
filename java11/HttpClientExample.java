package java11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpHeaders;
import java.util.concurrent.CompletableFuture;


public class HttpClientExample {

    public static void main(String[] args) {
        HttpClientExample tester = new HttpClientExample();

        // Replace the URI with the actual REST service endpoint
        String restServiceUri = "https://example.com/api/resource";

        try {
            tester.syncGet(restServiceUri);

            // Async call
            CompletableFuture<String> asyncResult = tester.asyncGet(restServiceUri);
            asyncResult.thenAccept(response -> System.out.println("Async Response: " + response));

            // Sleep to allow async request to complete
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void syncGet(String uri) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        // Print response body
        System.out.println(response.body());

        // You can also print other information such as status code and headers
        System.out.println("Status Code: " + response.statusCode());

        HttpHeaders headers = response.headers();
        headers.map().forEach((k, v) -> System.out.println(k + ":" + v));


    }
    public CompletableFuture<String> asyncGet(String uri) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }
}

