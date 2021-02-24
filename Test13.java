package MyNewProject;

class A extends Thread{
    int t=0;
    public void run() {
      synchronized (this){
          for (int i = 0; i <= 2; i++) {
              t=t+i;

          }this.notify();
      }
    }
}
public class Test13 {
    public static void main(String[] args) throws InterruptedException {
        A a =new A();
        a.start();
        synchronized (a){
            System.out.println("This is main thread");
            a.wait();
            System.out.println("Main thread is notified");
            System.out.println(a);
        }
    }
}
