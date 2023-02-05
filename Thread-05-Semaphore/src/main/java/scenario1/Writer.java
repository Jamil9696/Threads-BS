package scenario1;

public class Writer implements Runnable{

  private final Semaphore db;
  private final Semaphore mutex;
   static private int wr = 1;

  public Writer(Semaphore db, Semaphore mutex){
    this.db = db;
    this.mutex = mutex;

  }
  @Override
  public void run(){

      writer();

  }

  public void doSth(int millis, String s){
    try {
      System.out.println(Thread.currentThread().getName() + ":" + s);
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void writer () {
    while ( true ) {
      doSth(100, "wishes work on data");
      mutex.p();
      doSth(100, "wishes work on data");
      wr++;
      if ( wr == 1) db.p();// for first reader
      doSth(100, "is working on Data from Frontend");
      mutex.v();
      doSth(100, "is updating db");
      mutex.p();
      wr--;
      System.out.println(Thread.currentThread().getName() + ": has finish his work");
      if ( wr == 0) db.v(); // release if last reader
      mutex.v();
    }
  }
}
