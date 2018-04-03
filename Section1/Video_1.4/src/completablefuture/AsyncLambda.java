package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class AsyncLambda {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Current Thread : " + Thread.currentThread().getName());
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Current Thread (SupplyAsync) : " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                throw new IllegalStateException(ex);
            }
            return "Result";
        }).thenApply(result -> {
            System.out.println("Current Thread (ThenApply) : " + Thread.currentThread().getName());
            return result.toUpperCase();
        });
        System.out.println("CompletableFuture Result : " + future.get());
    }
}
