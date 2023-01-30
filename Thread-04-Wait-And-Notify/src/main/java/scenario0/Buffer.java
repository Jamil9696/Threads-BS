package scenario0;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Buffer {

  private final List<Integer> list = new ArrayList<>();
  private boolean isFull = true;

  public void removeItem() throws InterruptedException  {

    synchronized (this.list) {
      while (isFull) {

        if (list.isEmpty()) {
          isFull = false;
          this.list.notifyAll();
          break;
        }
          // C1 takes the value but imagine here,
          int n = list.get(0);
          // ...the JVM suddenly take this thread into the runnable state right after and starts a new thread C2
          // C2 starts at line 15 and finds out that the list is not empty
          list.remove(0);

          // will notify the next thread who is waiting
          // notify();
          // When we don't know which one is the next one
          // we use notifyAll
          System.out.println(Thread.currentThread().getName() + " took out the value " + n + " from the list");
      }
        // Imagine the JVM actually enables a thread called Consumer1 and the list contains at the moment
        // one value list = { 100 }, and Thread C1 , C2
        // C1 checks the condition
      System.out.println(Thread.currentThread().getName() + " is waiting");
      this.list.wait();

      }

  }

  public void addItem() throws InterruptedException{

      Random r = new Random();

      synchronized (this.list) {

        while (!isFull) {

          if(list.size() >= 10){
            isFull = true;
            this.list.notifyAll();
            break;
          }
          int n = r.nextInt(1000); // [0,999]
          list.add(n);
          System.out.println(Thread.currentThread().getName() + " added Value: " + n + " to the list");
        }
        // put the current Thread to the stop state
        // All methods which blocks a thread, usually can throw an exception
        // producer waits now

        System.out.println(Thread.currentThread().getName() + " is waiting");
        this.list.wait();
      }
  }
}
