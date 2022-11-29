package scenario0;

import java.util.Random;

public class Producer extends Thread {

    public Producer(String name){
        super(name);

    }

    @Override
    public void run() {
        // 100
        Random r = new Random();
        while(true){

            if(Main.list.size() < 100){
                int n = r.nextInt(1000); // [0,999]
                Main.list.add(n);
                System.out.println(Thread.currentThread().getName() + " added Value: " + n + " to the list");
            }

        }
    }
}
