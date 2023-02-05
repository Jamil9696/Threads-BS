package scenario0;


public class T1 extends Thread{

  private final Semaphore[] semaphores;


  public T1(Semaphore[] semaphores) {
    this.semaphores = semaphores;
    start();
  }
  public void a1(){
    System.out.println("a1");
    try {
      sleep((int) (Math.random() * 10));
    }catch (InterruptedException e){
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    a1();
    semaphores[0].v();
    semaphores[1].v();
    semaphores[2].v();
  }
}
