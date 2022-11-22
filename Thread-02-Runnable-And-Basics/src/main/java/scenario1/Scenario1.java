package scenario1;

public class Scenario1 {


    public static void main(String[] args){

        // Thread - Lifecycles
        //     start()            dt = going back from Runnable to Running
        //  NEW ---> RUNNABLE <--------> RUNNING
        //             | ^               |
        //             | |________       | z.B. Thread.sleep(1000 (+ dt))
        //             v         |       v
        //            DEAD <----  BLOCKED
        //                  it's possible but illegal to stop Blocked Threads) !!!
        //                  interrupt(),
        //                  stop() //(deprecated)
        //
        //

        // Query to DB1 -> 3 seconds
        // Query to DB2 -> 2 seconds
        var db1 = new DB1Runnable();
        var db2 = new DB2Runnable();

        // Strategy 1: 3 + 2 = 5sek duration (when using single Thread)
        // Strategy 2: max(3, 2) = 3sek duration (when using multiple Threads)

        var t1 = new Thread(db1, "T1");
        var t2 = new Thread(db2, "T2");

        // In any case, we have to wait with the processing step as long as
        // the Threads are still running independently
        // We can't control Threads while there are between two states (for example between RUNNABLE and RUNNING)

        // Strategy 1: using priorities
        // 1) you can choose between 1-10,
        // 2) default priority is 5,
        // 3) Theoretically, we can assign priorities to a thread
        // 4) DON'T USE IT IN REAL WORLD SCENARIOS, it's not a way to synchronize Threads
        t1.setPriority(5);

        // Strategy 1: join()
        // When I control my main thread to NOT continue until the other Threads are finished
        // program would work as expected
        t1.start();
        t2.start();
        // processing (working with read data)

        // it will actually block the current Thread so that the current thread waits for the thread
        // you refer the method from (t1 and t2 in this case).
        // In this case the main thread will wait for t1 and t2 to finish
        try {
            // Main method wait to join t1 and t2
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("processing......");

    }
}
