package prio;

//File Name : GuessANumber.java
//Extending Thread

public class GuessANumber extends Thread {
   private final int number;
public GuessANumber(String name, int number) {
   this.number = number;
   setName(name);
}

public void run() {
   int counter = 0;
   int guess = 0;
   do {
      guess = (int) (Math.random() * 100 + 1);
      System.out.println(this.getName() + " guesses " + guess);
      counter++;
   } while(guess != number);
   	  System.out.println(String.format("** Correct! %s after %s guesses.**", this.getName(), counter));
   }
}