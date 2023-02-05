package scenario2;

public class AdditiveSemaphore {

  private int value;

  public AdditiveSemaphore(int value){
    this.value = value;
  }

  public synchronized void v(int x){
    if(x <= 0) return;

    value += x;
    notifyAll();
  }

  public void change(int x){
    if(x > 0) v(x);
    else if(x < 0) p(-x);
  }

  public synchronized void p(int x){
    if(x <= 0)return;

    while (value - x < 0){
      try {
        wait();
      }catch (InterruptedException e){
        e.printStackTrace();
      }
    }
    value -= x;

  }

}
