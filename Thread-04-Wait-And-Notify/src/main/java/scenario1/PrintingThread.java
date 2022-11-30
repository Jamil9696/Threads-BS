package scenario1;

public class PrintingThread extends Thread{
    @Override
    public void run() {

        try {

        while (true){
            System.out.println(Main.c);
            Thread.sleep(500);
        }

        }catch (InterruptedException e){
          e.printStackTrace();
        }
    }
}
