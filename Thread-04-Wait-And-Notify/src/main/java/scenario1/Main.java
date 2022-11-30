package scenario1;

public class Main {

    public static volatile int c = 0;
    public static void main(String[] args) {

        // Threads could run on different cpus ( here cpu1 and cpu2 for example )
        // and each cpu has its own cache memory.
        // Therefore, it might be that the variable c
        // is only incremented at the cpu 1 level and not in the main memory
        // So different values exists for the variable c

        // By adding volatile, all changes to the variable c are also
        // transferred to the main memory
        IncrementingThread i = new IncrementingThread();
        PrintingThread p = new PrintingThread();
        p.start();
        i.start();



    }
}
