package scenario0;

public class Consumer implements Runnable{

    private final Buffer buffer;
    public Consumer( Buffer buffer){

        this.buffer = buffer;
    }



    @Override
    public void run() {

        try {

            while (true) {
                // Imagine the JVM actually enables a thread called Consumer1 and the list contains at the moment
                // one value list = { 100 }, and Thread C1 , C2

                // C1 checks the condition

                // C1 takes the value but imagine here,
                buffer.removeItem();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
