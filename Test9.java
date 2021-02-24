package MyNewProject;
//9. Increase concurrency with Thread pools using newCachedThreadPool() and newFixedThreadPool().
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test9 {
    public static void main(String[] args) {
       // ExecutorService service= Executors.newFixedThreadPool(4);(remove comment to run)
        ExecutorService service= Executors.newCachedThreadPool(); //(we do not need to assign threads here because it will
                                                                    // allocate according to the given task and increase threads
                                                                    // if other threads are busy in the queue )
        for (int i = 0; i < 20; i++) {
            service.execute(new Task());
            System.out.println("Thread Name: "+Thread.currentThread().getName());
        }
    }
 static class Task implements Runnable {
     @Override
     public void run() {
         System.out.println("Thread name: "+Thread.currentThread().getName());
     }
 }
}
