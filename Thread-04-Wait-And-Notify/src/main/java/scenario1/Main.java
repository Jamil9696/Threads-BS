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

        // But it doesn't solve the synchronized problem !!!
        // (you can see it by running this program. You see that some
        // numbers will not be printed)

        // !!!! important !!!
        // Volatile only synchronize the way from each cpu to the memory
        // but not from the memory back to the cpu

        // to solve it, you use the synchronize-keyword

        IncrementingThread i = new IncrementingThread();
        PrintingThread p = new PrintingThread();
        p.start();
        i.start();



    }
}
