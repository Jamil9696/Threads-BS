package scenario0;

public class Consumer extends Thread{

    public Consumer(String name){
        super(name);
    }
    // Whenever one decision (instruction) has an impact on other processes (Threads)
    // we want to make sure that these operations (check if list is empty and remove element) are atomic.
    // In order to do that, we need to use the keyword synchronized

    /*
     Synchronized definition
     Ones a thread has entered and acquired what we call a lock no other thread will be allowed to enter
     until the one inside releases his lock

     */

     //One way:
     public void method1(){

       // by using synchronized as a method,
       // we have to decide which is our monitor which will be specified between the round parenthesis of the method.
       // A monitor manages the synchronized block of code. He is responsible to execute the code
       // inside the synchronized block
       // Technically speaking, any thread could be managed the synchronized block. He simply needs to be the first one.

       // so we could pass "this" as parameter ( synchronized(this) ). But this will only work when several processes
       // are belonging to the same Thread (by using the method run() at the beginning)
       // When the threads are real-parallel then there are different Threads which are independent of each other
       // and each thread will be able to execute the synchronized block

       String list = "";
       //synchronized(this) { will work when all processes belongs to the same thread

       synchronized(Main.list) {

          if(Main.list.isEmpty()){
            // do sth
            //  ...
            // remove item from the list
          }
       }
     }


    @Override
    public void run() {

        while(true){
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
                    System.out.println(Thread.currentThread().getName() + " took out the value " + n + " from the list");
                }
            }
        }
    }
}
