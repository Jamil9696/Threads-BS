public class Main {

    /* In case of Java,the first Thread that starts with the Main Method is also called main
       If we have only one Thread we call this program a single Thread program
       In general, we have always more than one Threads running.
       The Java virtual maschine has its own Threads, one for the Garbage Collector for example

       When we create a new Thread, the thread creation process needs some time until the new thread actually starts to run



     */

    // starting point of the Main Thread
    public static void main(String[] args) {

        // Thread - Lifecycles
        //     start()         dt = going back from Runnable to Running
        //  NEW ---> RUNNABLE <--------> RUNNING
        //             | ^               |
        //             | |________       | z.B. Thread.sleep(1000 (+ dt))
        //             v         |       v
        //            DEAD <---- BLOCKED
        //                  it's illegal to stop Blocked Threads) !!!
        //                  interrupt(),
        //                  stop()(deprecated):
        //
        //
        // If I only instantiate the object than the Thread will go to the NEW Stage but will not start yet
        // By calling the start() method the Thead will go into a stage that we call the runnable lifecycle state
        // and from this state, the Java Virtual Machine can take this Thread and execute it at some point
        // Even though the Thread is in the runnable stage, it doesn't mean that he will be executed
        // When your Hardware allows you to execute 4 Threads at the time for example, it needs to have 4 CPUs available.
        // Imagine in some point, the hardware can only execute 2 additional Threads and the application want to execute
        // 4 Threads. It won't be able to execute all 4 of them. In that case the Java Virtual Machine will only place into
        // execution (Running State) as many Threads he can. When a thread finish his Thread it goes into the dead state.
        // A dead Thread can not be executed twice (for example be calling start() again later on),
        // it will throw a IllegalStateException
        // When we want to execute the same code independently again at some point, we have to instantiate and run a new Thread
        // Threads can be blocked but after the blocking time is exceeded, the Thread will go back to the runnable state until
        // he can be executed

        EvenNumberThread even = new EvenNumberThread();

        // run() represents the main method that you will override (using inheritance)
        // and by overriding run(), you define what this Thread is doing

        even.start();
        // run() means that this new Thread it will be executed INSIDE the Thread in which run() is called
        // Therefore, we don't have multiple Threads here.
        // start() means that you want your Thread here to begin the execution

        // because the even Thread needs a specific time to be created before it can run,
        // This println will be most likely printed first
        System.out.println("END!");


    }
}
