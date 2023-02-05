package scenario0;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    Semaphore[] semaphores = new Semaphore[6];
    for (int i = 0; i < 6; i++){
      semaphores[i] = new Semaphore(0);
    }

    new T1(semaphores);
    new T2(semaphores);
    new T3(semaphores);
    new T4(semaphores);
    new T5(semaphores);

  }
}
