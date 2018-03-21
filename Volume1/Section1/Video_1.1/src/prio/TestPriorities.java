package prio;

//File Name : ThreadClassDemo.java
public class TestPriorities {

	public static void main(String [] args) {
	   final Runnable hello = new DisplayMessage("Hello");
	   final Thread helloThread = new Thread(hello);
	   helloThread.setDaemon(true);
	   helloThread.setName("hello");
	   System.out.println("Starting hello thread...");
	   helloThread.start();
	   
	   final Runnable bye = new DisplayMessage("Goodbye");
	   final Thread byeThread = new Thread(bye);
	   byeThread.setPriority(Thread.MIN_PRIORITY);
	   byeThread.setDaemon(true);
	   System.out.println("Starting goodbye thread...");
	   byeThread.start();
	
	   System.out.println("Starting guess thread...");
	   final Thread guessThread = new GuessANumber("Guess Thread", 27);
	   guessThread.start();
	   try {
	      guessThread.join();
	   }catch(InterruptedException e) {
	      System.out.println("Thread interrupted.");
	   }
	   System.out.println("Starting guess thread2...");
	   final Thread guessThread2 = new GuessANumber("Guess Thread-2", 75);
	   
	   guessThread2.start();
	   System.out.println("main() is ending...");
	}
}