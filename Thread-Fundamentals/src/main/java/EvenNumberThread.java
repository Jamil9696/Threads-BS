

/*
Usually in real scenarios, we don't extend from thread class.
There are better approaches which are better from maintainability point of view of the application
 */


public class EvenNumberThread extends Thread {


    @Override
    public void run() {
        for (int i = 0; i <= 10; i+=2 ){
            System.out.println(i);
        }
    }
}
