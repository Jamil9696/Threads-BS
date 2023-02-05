package scenario0;

public class T5 extends Thread{

  private final Semaphore[] semaphores;


  public T5(Semaphore[] semaphores) {
    this.semaphores = semaphores;
    start();
  }
  public void a5(){
    System.out.println("a5");
    try {
      sleep((int) (Math.random() * 10));
    }catch (InterruptedException e){
      e.printStackTrace();
    }
  }

  @Override
  public void run() {

    semaphores[3].p();
    semaphores[4].p();
    semaphores[5].p();
    a5();
  }
}
