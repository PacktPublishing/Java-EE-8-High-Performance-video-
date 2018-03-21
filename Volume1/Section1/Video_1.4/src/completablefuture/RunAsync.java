package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class RunAsync {
	public static void main(String[] args) throws Exception {
		System.out.println("Current Thread : " + Thread.currentThread().getName());
		// Run a task specified by a Runnable Object asynchronously.
		final CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
		    @Override
		    public void run() {
		        // Simulate a long running Job
		        try {
		            TimeUnit.SECONDS.sleep(5);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
		        System.out.println("I'll run in a separate thread than the main thread.");
		        System.out.println("Current Thread : " + Thread.currentThread().getName());
		    }
		});

		// Block and wait for the future to complete
		future.get();
	}
}
