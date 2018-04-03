package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllOf {

	public static void main(String[] args) throws Exception {
		CompletableFuture<String> future1  
		  = CompletableFuture.supplyAsync(() -> "Hello");
		CompletableFuture<String> future2  
		  = CompletableFuture.supplyAsync(() -> "Beautiful");
		CompletableFuture<String> future3  
		  = CompletableFuture.supplyAsync(() -> "World");
		 
		CompletableFuture<Void> combinedFuture 
		  = CompletableFuture.allOf(future1, future2, future3);
		 	 
		combinedFuture.get();
		 
		if (future1.isDone() && future2.isDone() && future3.isDone()) {
			//System.out.println(future1.get() + " " + future2.get() + " " + future3.get());
			final String combined = Stream.of(future1, future2, future3)
					  .map(CompletableFuture::join)
					  .collect(Collectors.joining(" "));
			System.out.println(combined);
			System.out.println("All done.");
			System.exit(0);
		}
	}
}
