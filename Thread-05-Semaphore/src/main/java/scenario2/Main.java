package scenario2;

import scenario1.Reader;
import scenario1.Semaphore;
import scenario1.Writer;

public class Main{










  public static void main(String[] args) {

    AdditiveSemaphore additiveSemaphore = new AdditiveSemaphore(3);

    Runnable r1 = new T1(additiveSemaphore);
    Runnable r2 = new T2(additiveSemaphore);

    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);

    t1.start();
    t2.start();














  }

}
