package scenario1;

public class Main extends Thread{










  public static void main(String[] args) {
    Semaphore mutex = new Semaphore(1); // controls access to rc
    Semaphore db =  new Semaphore(1); // controls access to DB
    int rc = 0; // # processes reading or wanting to




    Thread t1 = new Thread( new Writer(db, mutex), "w1" );
    Thread t2 = new Thread( new Writer(db, mutex), "w2");
    Thread t3 = new Thread(new Reader( db), "r1");
    Thread t4 = new Thread(new Reader( db), "r2");
    Thread t5 = new Thread(new Reader( db), "r3");
    Thread t6 = new Thread(new Reader( db), "r4");
    Thread t7 = new Thread(new Reader( db), "r5");
    Thread t8 = new Thread(new Reader( db), "r6");
    Thread t9 = new Thread(new Reader( db), "r7");
    Thread t10 = new Thread(new Reader( db), "r8");

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
    t6.start();
    t7.start();
    t8.start();
    t9.start();
    t10.start();










  }

}
