package MyNewProject;
//5.Use isShutDown() and isTerminated() with ExecutorService.
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Demo5 implements Runnable {

        String s;

        Demo5(String str) {
            s = str;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Name:- " + s + " Value:- " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public class Test5{
        public static void main(String[] args) {
            Runnable t1 = new Demo5("Thread 1");
            Runnable t2 = new Demo5("Thread 2");
            Runnable t3 = new Demo5("Thread 3");

            ExecutorService es1 = Executors.newFixedThreadPool(1);
            System.out.println(es1.isShutdown());
            es1.execute(t1);
            es1.execute(t2);
            es1.execute(t3);
            es1.shutdown();
            System.out.println(es1.isShutdown());
            System.out.println(es1.isTerminated());
        }
    }

