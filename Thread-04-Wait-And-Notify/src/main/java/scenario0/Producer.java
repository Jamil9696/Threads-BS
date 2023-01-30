package scenario0;

import java.util.Random;

public class Producer implements Runnable {

    private Buffer buffer;

    // When calling wait and notify, we always call these methods
    // inside a synchronized block
    // 1. Never call these methods from outside the synchronized block !!
    // 2. That object from which you call wait or notify is always the monitor !!!
    // 3. Once a thread is blocked by using wait(), you also have to start him again
    //    Otherwise he will wait forever

    public Producer( Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run()  {

        try {
            Random r = new Random();


            while (true) {
              buffer.addItem();
            }
        }catch( InterruptedException e){
            e.printStackTrace();
        }
    }
}
