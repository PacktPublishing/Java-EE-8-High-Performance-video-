package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimpleFuture {
	static Future<String> calculateFuture() throws InterruptedException {
		final CompletableFuture<String> result = new CompletableFuture<>();
		Executors.newCachedThreadPool().submit(() -> {
			Thread.sleep(3000);
			result.complete("Future's Result");
			return null;
		});
		return result;
	}

	public static void main(String[] args) throws Exception {
		final Future<String> future = calculateFuture();
		final String result = future.get();
		System.out.println(result);
		System.exit(0);
	}
}
