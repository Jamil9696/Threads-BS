package scenario0;

public class T3 extends Thread{

  private final Semaphore[] semaphores;


  public T3(Semaphore[] semaphores) {
    this.semaphores = semaphores;
    start();
  }
  public void a3(){
    System.out.println("a3");
    try {
      sleep((int) (Math.random() * 10));
    }catch (InterruptedException e){
      e.printStackTrace();
    }
  }

  @Override
  public void run() {

    semaphores[1].p();
    a3();
    semaphores[4].v();

  }
}
