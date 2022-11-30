package scenario0;

import java.util.Random;

public class Producer extends Thread {

    // When calling wait and notify, we always call these methods
    // inside a synchronized block
    // 1. Never call these methods from outside the synchronized block !!
    // 2. That object from which you call wait or notify is always the monitor !!!
    // 3. Once a thread is blocked by using wait(), you also have to start him again
    //    Otherwise he will wait forever

    public Producer(String name){
        super(name);
    }

    @Override
    public void run()  {
        // 100

        try {
            Random r = new Random();


            while (true) {

                synchronized (Main.list) {
                    if (Main.list.size() < 100) {
                        int n = r.nextInt(1000); // [0,999]
                        Main.list.add(n);
                        notifyAll();
                        System.out.println(Thread.currentThread().getName() + " added Value: " + n + " to the list");
                    } else {

                        // put the current Thread to the stop state
                        // All methods which blocks a thread, usually can throw an exception

                        // producer waits now
                        Main.list.wait();
                    }
                }
            }
        }catch( InterruptedException e){
            e.printStackTrace();
        }
    }
}
