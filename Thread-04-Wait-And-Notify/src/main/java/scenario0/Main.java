package scenario0;

import java.util.ArrayList;
import java.util.List;

public class Main {



    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {


        Producer p1 = new Producer("p1");
        Producer p2 = new Producer("p2");
        // 1) when for example c1 manages to access to the lock, the monitor (here the array list)
        //    takes care that other threads don't interfere. The monitor will be defined by using synchronized+

        // 2) the other c-threads will continue to run but do nothing
        //    or the list is empty but, the consumer threads continue to
        //    check the condition

        //3) the c-threads should therefore automatically stop and
        //   let a producer work in his place. The same goes also for the producer
        //   Once the list is full, no producer will be needed anymore

        //4) We can make our thread management more performant


        Consumer c1 = new Consumer("c1");
        Consumer c2 = new Consumer("c2");
        Consumer c3 = new Consumer("c3");

       /*
        p1.run();
        p2.run();
        c1.run();
        c2.run();
        c3.run();
        /*/

        p1.start();
        p2.start();
        c1.start();
        c2.start();
        c3.start();





    }
}
