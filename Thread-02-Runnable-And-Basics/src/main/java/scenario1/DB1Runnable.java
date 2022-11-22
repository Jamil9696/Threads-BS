package scenario1;

public class DB1Runnable implements Runnable{


    @Override
    public void run() {
        // Every Method that refers to blocking a thread, that method throws always an InterruptedException

        try {
            Thread.sleep(3000); // doing some DB operations which takes 3 seconds
            System.out.println("DB 1 querying ended...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
