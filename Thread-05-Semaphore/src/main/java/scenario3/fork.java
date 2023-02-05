package scenario3;



class myInt {
  private int value;
  public myInt(int x) {
    value = x;
  }
  public void set(int x) {
    value = x;
  }
  public void inc() {
    value++;
  }
  public int get() {
    return value;
  }
}
public class fork extends Thread {
  myInt i;
  fork(myInt i) {
    this.i = i;
    start();
  }
  public void run() {
    synchronized (i) {
      i.inc();
      System.out.println(getName() + ": " + i.get());
    }
  }
  public static void main(String[] args) {
    myInt x = new myInt(0);
    fork t1 = new fork(x);
    fork t2 = new fork(x);
    fork t3 = new fork(x);
  }
}