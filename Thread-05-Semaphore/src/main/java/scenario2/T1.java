package scenario2;

public class T1 implements Runnable{

  private final AdditiveSemaphore semaphore;

  public T1(AdditiveSemaphore semaphore) {
    this.semaphore = semaphore;
  }


  @Override
  public void run() {

    while (true){
      System.out.println(Thread.currentThread().getName() + ": " + "wants to access semaphore");
      //                    1ms 2ms
      semaphore.p(1); // T1 T2
      semaphore.p(1); // T1 T2 -> wait
      semaphore.p(2);  // T1  T2-> get Notified
      System.out.println(Thread.currentThread().getName() + ": " + "is working"); // T1 T2 sind beide drin
      System.out.println(Thread.currentThread().getName() + ": " + "is not accessing semaphore anymore");
      semaphore.v(1);
      semaphore.v(1);
      semaphore.v(2);


    }

  }
}
