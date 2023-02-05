package scenario0;

public class T4 extends Thread{

  private final Semaphore[] semaphores;


  public T4(Semaphore[] semaphores) {
    this.semaphores = semaphores;
    start();
  }
  public void a4(){
    System.out.println("a4");
    try {
      sleep((int) (Math.random() * 10));
    }catch (InterruptedException e){
      e.printStackTrace();
    }
  }

  @Override
  public void run() {

    semaphores[2].p();
    a4();
    semaphores[5].v();

  }
}
