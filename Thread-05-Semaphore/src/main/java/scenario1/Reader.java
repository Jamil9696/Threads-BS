package scenario1;

public class Reader implements Runnable {

  private final Semaphore db;


  public Reader(Semaphore db){
    this.db = db;
  }

  public void doSth(int millis, String s){
    try {

      if(!s.isEmpty())
      System.out.println(Thread.currentThread().getName() + ":" + s);
      Thread.sleep(millis);


    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run(){

       reader();
  }

  public void  reader () {
    while ( true ) { // repeat forever

      doSth(100, "wishes to read");
      db.p();// for first reader
      doSth(100, "is accessing DB");
      db.v(); // release if last reader
      doSth(100, "not accessing anymore");
    }
  }
}
