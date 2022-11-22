package scenario0;

public class Scenario0 {


    public static void main(String[] args) {

        var r1 = new OddNumbersRunnable();


        // we can also directly instantiate a Thread object and pass an OddNUmberRunnable to its constructor
        // this is possible because the OddnumbersRunnable class implements the runnable interface

        var t1 = new Thread(r1, "T1"); // Thread with name T1: Current Lifecycle: NEW-state

        var t2 = new Thread(r1, "T2");
        // this Thread will be started independently because we're calling the start() method
        // but the Thread-2 has a reference to an OddNumbersRunnable instance which will execute
        // the run method() INSIDE the "T1"-Thread

        // without synchronizing them, we don't know which number will be printed next
        t1.start(); // Thread Lifecycle: RUNNABLE-State
        t2.start();

    }
}
