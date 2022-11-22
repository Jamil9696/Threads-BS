package scenario0;

public class OddNumbersRunnable implements Runnable{


    /* When using inheritance, whenever we want to instantiate an object which inherit the Thread class
       we actually create a more particular type of thread. But by using the Runnable interface, we decouple
       this class from the thread. Therefore, this object is not considered to be a Thread object anymore */

    // when using inheritance, we can but don't have to override function
    // The runnable interface contains an abstract method.
    // That's why we have no other possibility than to override this function

    @Override
    public void run() {
        for(int i = 0; i <=11 ; i +=2){
            System.out.println(i + " " + Thread.currentThread().getName());
        }
    }
}