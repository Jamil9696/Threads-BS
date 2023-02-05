package scenario2;

public class T2 implements Runnable{

  private final AdditiveSemaphore semaphore;

  public T2(AdditiveSemaphore semaphore) {
    this.semaphore = semaphore;
  }


  @Override
  public void run() {

    while (true){
      System.out.println(Thread.currentThread().getName() + ": " + "wants to access semaphore");
      semaphore.p(1);
      semaphore.p(1);
      semaphore.v(2);
      System.out.println(Thread.currentThread().getName() + ": " + "is working");
      System.out.println(Thread.currentThread().getName() + ": " + "is not accessing semaphore anymore");
      semaphore.v(1);
      semaphore.v(1);
      semaphore.p(2);
    }

  }
}
