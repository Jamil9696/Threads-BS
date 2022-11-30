package scenario0;

import java.util.ArrayList;
import java.util.List;

public class Main {



    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {


        Producer p1 = new Producer("p1");
        Producer p2 = new Producer("p2");
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
