package prio;

//File Name : DisplayMessage.java
//Implementing Runnable

public class DisplayMessage implements Runnable {
   private final String message;

public DisplayMessage(String message) {
   this.message = message;
}

public void run() {
   while(true) {
      System.out.println(message);
   }
}
}