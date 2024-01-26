package java9;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class FlowExample {
    public static void main(String[] args) throws InterruptedException {
        try (SubmissionPublisher<String> publisher = new SubmissionPublisher<>()) {
            publisher.subscribe(new StockPriceSubscriber());

            String[] stocks = {"AAPL", "GOOGL", "MSFT", "AMZN", "FB"};

            for (int i = 0; i < 10; i++) {
                for (String stock : stocks) {
                    double price = Math.random() * 1000; 
                    publisher.submit(stock + ": " + String.format("%.2f", price));
                }
            }

        }
    }
            
}

        

class StockPriceSubscriber implements Flow.Subscriber<String> {
    private Flow.Subscription subscription;
            
    @Override
    public void onComplete() {
        System.out.println("StockPriceSubscriber: Completed");
    }
            
    @Override
    public void onError(Throwable err) {
        System.out.println("StockPriceSubscriber: Error - " + err.getMessage());
    }
            
    @Override
    public void onNext(String item) {
        System.out.println("StockPriceSubscriber: Received Stock Price - " + item);
        requestItem(subscription);
    }
            
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        requestItem(subscription);
    }
            
    private void requestItem(Flow.Subscription subscription) {
        System.out.println("Subscribed, requesting 1 item...");
        subscription.request(1);
    }
}

        