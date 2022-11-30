package scenario0;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // the arrayList and all those other Lists like Sets or maps are not
    // synchronized by default anyhow
    // !!!!This means that the methods provided by arraylist class are also not synchronized !!!

    // shared resource -> whenever a thread works with this list, it's only one Thread at a time accesses it
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {


        Producer p1 = new Producer("p1");
        Producer p2 = new Producer("p2");
        Consumer c1 = new Consumer("c1");
        Consumer c2 = new Consumer("c2");
        Consumer c3 = new Consumer("c3");

        // When we don't synchronize the threads
        // The consumer stops at some points due to thrown exceptions (trying to remove elements when the list is already empty)
        // and the producers continuously start running doing nothing because the list is still filled
        // so they become zombies and just consuming cpu
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
