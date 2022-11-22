

/*
Usually in real scenarios, we don't extend from thread class.
There are better approaches which are better from maintainability point of view of the application
 */


public class EvenNumberThread extends Thread {


    @Override
    public void run() {
        try {
        for (int i = 0; i <= 10; i+=2 ){

            System.out.println(i);
                Thread.sleep(1000);
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
            // it never happens because there is no other Thread being able
            // to interrupt this Thread while he's sleeping, but I still have to
            // treat this case
        }
    }
}
