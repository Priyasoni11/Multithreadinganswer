package MyNewProject;
//3.Use a singleThreadExecutor to submit multiple threads.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test3 {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Runnable task1 = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("My task1 is started..");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("my task1 has ended");

        };
        Runnable task2 = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("My task2 is started..");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("my task2 has ended");

        };
        Runnable task3 = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("My task3 is started..");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("my task3 has ended");

        };
        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);
    }
}
