package completablefuture;

import java.util.concurrent.CompletableFuture;

public class Compose {
	public static void main(String[] args) throws Exception {
		final CompletableFuture<String> completableFuture 
		  = CompletableFuture.supplyAsync(() -> "Hello")
		    .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));
		 
		System.out.println(completableFuture.get());
	}
}
