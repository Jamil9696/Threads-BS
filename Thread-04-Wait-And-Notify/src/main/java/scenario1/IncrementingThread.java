package scenario1;

public class IncrementingThread extends Thread{

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++){
            // when incrementing this variable and printing it in the other thread
            Main.c++;
            Thread.sleep(500);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
