package scenario1;

public class DB2Runnable implements Runnable{


    @Override
    public void run() {
        // Every Method that refers to blocking a thread, that method throws always an InterruptedException

        try {
            Thread.sleep(2000); // doing some DB operations which takes 3 seconds
            System.out.println("DB 2 querying ended...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
