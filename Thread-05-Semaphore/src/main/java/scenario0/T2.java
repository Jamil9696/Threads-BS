package scenario0;

public class T2 extends Thread{

  private final Semaphore[] semaphores;


  public T2(Semaphore[] semaphores) {
    this.semaphores = semaphores;
    start();
  }
  public void a2(){
    System.out.println("a2");
    try {
      sleep((int) (Math.random() * 10));
    }catch (InterruptedException e){
      e.printStackTrace();
    }
  }

  @Override
  public void run() {

    semaphores[0].p();
    a2();
    semaphores[3].v();

  }
}
