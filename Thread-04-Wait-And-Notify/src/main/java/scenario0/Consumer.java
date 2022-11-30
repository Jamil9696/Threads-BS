package scenario0;

public class Consumer extends Thread{

    public Consumer(String name){
        super(name);
    }



    @Override
    public void run() {

        try {

            while (true) {
                // Imagine the JVM actually enables a thread called Consumer1 and the list contains at the moment
                // one value list = { 100 }, and Thread C1 , C2

                // C1 checks the condition
                synchronized (Main.list) {
                    if (!Main.list.isEmpty()) {

                        // C1 takes the value but imagine here,
                        int n = Main.list.get(0);
                        // ...the JVM suddenly take this thread into the runnable state right after and starts a new thread C2
                        // C2 starts at line 15 and finds out that the list is not empty

                        Main.list.remove(0);

                        // will notify the next thread who is waiting
                        // notify();

                        // When we don't know which one is the next one
                        // we use notifyAll
                        notifyAll();
                        System.out.println(Thread.currentThread().getName() + " took out the value " + n + " from the list");
                    } else {
                        Main.list.wait();
                    }
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
