package scenario0;


public class Main {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();

        Producer p1 = new Producer( buffer);
        Producer p2 = new Producer(buffer);
        // 1) when for example c1 manages to access to the lock, the monitor (here the array list)
        //    takes care that other threads don't interfere. The monitor will be defined by using synchronized+

        // 2) the other c-threads will continue to run but do nothing
        //    or the list is empty but, the consumer threads continue to
        //    check the condition

        //3) the c-threads should therefore automatically stop and
        //   let a producer work in his place. The same goes also for the producer
        //   Once the list is full, no producer will be needed anymore

        //4) We can make our thread management more performant


        Consumer c1 = new Consumer( buffer);
        Consumer c2 = new Consumer( buffer);
        Consumer c3 = new Consumer( buffer);

        Thread t1 = new Thread( c1 , "c1");
        Thread t2 = new Thread( c2 , "c2");
        Thread t3 = new Thread( c3 , "c3");
        Thread t4 = new Thread( p1 , "p1");
        Thread t5 = new Thread( p2 , "p2");


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();





    }
}
